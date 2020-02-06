package subastaDAO;

import java.util.LinkedList;
import java.util.List;

import subasta.Subasta;
import subasta.Puja;
import subasta.Usuarios;

public class SubastaDAO {

	List<Subasta> subastas;
	
	/*public SubastaDAO() {
		subastas=new LinkedList();
	}*/
	
	public SubastaDAO(String producto, Usuarios propietario) {
		this.subastas.add(new Subasta(producto, propietario));
	}
	//Propiedad calculada	
	public Puja PujaMayor(int i){
		/*if (!pujas.isEmpty()) {
			return pujas.getLast();
		}else {
			return null;
		}*/
		return subastas.get(i).getPujaMayor();
	}
	/**
	 * 	Este metodo permite realizar una puja sobre la subasta. La informacion necesaria 
	 *  para pujar es el usuario que realiza la puja y la cantidad por la que puja. 
	 *  La puja es aceptada si: 
	 *    a) la subasta esta abierta, 
	 *    b) el credito del usuario que la realiza es suficiente para la cantidad por la que puja; 
	 *    c) el usuario no es propietario de la subasta y 
	 *    d) la cantidad es mayor que la cantidad de la puja mayor, si la hubiera. 
	 *  Por tanto, esta operacion finaliza indicando si la puja ha sido aceptada (retorna un valor booleano). 
	 *  Si la puja es aceptada, entonces se construye una puja y se almacena en la lista de pujas
	 * 	
	 * @param pujador Usuarios que realiza la puja
	 * @param cantidad cantidad por la que se puja
	 * @return true si la puja se ha realizado y false en caso contrario
	 */	
	public boolean pujar(Usuarios pujador, double cantidad, int i) {
		return subastas.get(i).pujar(pujador, cantidad);
	}
	/**
	 * 	Este metodo permite pujar sin indicar la cantidad, es decir, solo se requiere indicar el usuario que la realiza. 
	 *  La cantidad sera un euro mas que la cantidad de la puja mayor. 
	 *  Si no hubiera puja mayor, la cantidad sería de un euro.
	 *  
	 * @param pujador usuario que realiza la puja
	 * @return true si se ha realizado la puja y false en caso contrario
	 */
	public boolean pujar(Usuarios pujador, int i) {
		return subastas.get(i).pujar(pujador);
	}
	/**
	 * 	
	 * @return true la puja se ha cerrado.
	 */
	public boolean cerrar(int i) {
		return subastas.get(i).cerrar();
	}
	/**
	 * 	Este metodo ejecuta la subasta realizando las transferencias de credito entre 
	 *  el usuario que ha ganado la subasta (puja mayor) y el usuario propietario. Es posible ejecutar 
	 *  una subasta si se ha realizado alguna puja y la subasta está abierta. En tal caso, la ejecucion 
	 *  de una subasta consiste en decrementar el credito del usuario que ha realizado la puja mayor e 
	 *  incrementar el credito del propietario de la subasta por la cantidad de la puja mayor. 
	 *  Una vez ejecutada, la subasta quedara cerrada. El metodo finaliza informando si la subasta 
	 *  ha podido ejecutarse o no (retorna un valor booleano).
	 *  
	 * @return true si la subasta ha podido ejecutarse y false en caso contrario
	 */
	public boolean ejecutarSubasta(int i) {
		return subastas.get(i).ejecutar();
	}
}

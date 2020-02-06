package subasta;

import java.util.LinkedList;
import java.util.List;

import subasta.Usuarios;
import subasta.Puja;

/**
 * La subasta representa un producto por el que se puede pujar.
 * 
 * @author JoseRuso
 * @author Juan
 * @author Miriam
 *
 */
public class Subasta {

	private final String producto;
	private Usuarios propietario;
	private boolean abierta;
	private LinkedList<Puja> pujas;
/**
 * 	
 * @param producto
 * @param propietario
 */
	Subasta(String producto, Usuarios propietario){
		this.producto=producto;
		this.propietario = propietario;
		this.abierta = true;
		this.pujas = new LinkedList<Puja>();
		this.propietario.addSubasta(this);
	}
	
	public String getProducto() {
		return producto;
	}

	public Usuarios getPropietario() {
		return propietario;
	}

	public boolean getAbierta() {
		return abierta;
	}
	
	public String getMostraCrearSubasta() {
		return "Objeto a subastar: "+producto+". Creador de la Subasta: "+propietario;
	}
	
	public List<Puja> getPujas() {
		return new LinkedList<Puja>(pujas);
	}
	
	public String getMostrarPuja() {
		return "Pujador: "+getPujas();
	}
	
	//Propiedad calculada
	public Puja getPujaMayor(){
		if (!pujas.isEmpty()) {
			return pujas.getLast();
		}else {
			return null;
		}
	}
/**
 * 	Este método permite realizar una puja sobre la subasta. La información necesaria 
 *  para pujar es el usuario que realiza la puja y la cantidad por la que puja. 
 *  La puja es aceptada si: 
 *    a) la subasta está abierta, 
 *    b) el crédito del usuario que la realiza es suficiente para la cantidad por la que puja; 
 *    c) el usuario no es propietario de la subasta y 
 *    d) la cantidad es mayor que la cantidad de la puja mayor, si la hubiera. 
 *  Por tanto, esta operación finaliza indicando si la puja ha sido aceptada (retorna un valor booleano). 
 *  Si la puja es aceptada, entonces se construye una puja y se almacena en la lista de pujas
 * 	
 * @param pujador Usuarios que realiza la puja
 * @param cantidad cantidad por la que se puja
 * @return true si la puja se ha realizado y false en caso contrario
 */
	public boolean pujar (Usuarios pujador, double cantidad){
		if (getAbierta() && pujador.getCredito() >= cantidad && pujador != propietario &&
			(getPujaMayor() == null || (getPujaMayor() != null && getPujaMayor().getCantidad() < cantidad))){
				
			Puja puja = new Puja(pujador, cantidad);
				
			pujas.add(puja);
				
			return true;
		}else {
			return false;
		}
	}
/**
 * 	Este método permite pujar sin indicar la cantidad, es decir, sólo se requiere indicar el usuario que la realiza. 
 *  La cantidad será un euro más que la cantidad de la puja mayor. 
 *  Si no hubiera puja mayor, la cantidad sería de un euro.
 *  
 * @param pujador usuario que realiza la puja
 * @return true si se ha realizado la puja y false en caso contrario
 */
	public boolean pujar(Usuarios pujador){
		int cantidad = 1;
		
		if (getPujaMayor() != null) {
			cantidad += getPujaMayor().getCantidad();
		}
		return pujar (pujador, cantidad);
	}
/**
 * 	Este método cierra la subasta (la ejecuta) realizando las transferencias de crédito entre 
 *  el usuario que ha ganado la subasta (puja mayor) y el usuario propietario. Es posible ejecutar 
 *  una subasta si se ha realizado alguna puja y la subasta está abierta. En tal caso, la ejecución 
 *  de una subasta consiste en decrementar el crédito del usuario que ha realizado la puja mayor e 
 *  incrementar el crédito del propietario de la subasta por la cantidad de la puja mayor. 
 *  Una vez ejecutada, la subasta quedará cerrada. El método finaliza informando si la subasta 
 *  ha podido ejecutarse o no (retorna un valor booleano).
 *  
 * @return true si la subasta ha podido ejecutarse y false en caso contrario
 */
	public boolean ejecutar(){
		if (getAbierta() && getPujaMayor() != null){
			
			Usuarios ganador = getPujaMayor().getPujador();
			
			double cantidad = getPujaMayor().getCantidad();
			
			propietario.incrementarCredito(cantidad);
			
			ganador.decrementarCredito(cantidad);
			
			abierta = false;
			
			return true;
		
		} else
			return false;
	}
	
	@Override
	public String toString() {
		return getClass().getName() + " [producto=" + producto
									+ ", propietario=" + propietario.getNombre() 
									+ ", abierta=" + abierta
									+ ", pujas=" + pujas.size() 
									+ "]";
	}
}

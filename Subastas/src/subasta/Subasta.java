package subasta;

import java.time.LocalTime;
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
	private LocalTime tiempoSubasta;
	private int tiempoAbierta;
	
/**
 * 	constructor clase subasta.Se indica ademas del producto y propietario 
 * el tiempo que la subasta va a estar abierta. 
 * @param producto
 * @param propietario
 * @param tiempoAbierta
 */
	public Subasta(String producto, Usuarios propietario, int tiempoAbierta){
		this.producto=producto;
		this.propietario = propietario;
		this.abierta = true;
		this.tiempoAbierta=tiempoAbierta;
		this.pujas = new LinkedList<Puja>();
		this.propietario.addSubasta(this);
		tiempoSubasta=LocalTime.now().plusSeconds(tiempoAbierta);
	}
	
	/**
	 * getters
	 * @return producto , propietario, abierta , Crearsubasta , Pujas ,pujador
	 */
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
	
	//con un bucle if comprobamos si las pujas no estan vacias. y devuelve la ultima puja ya que sera la mas alta.
	//de lo contrario devuelbe un valor nulo
	
	/**
	 * Metodo para consegir la puja mayor
	 * @return
	 */
	public Puja getPujaMayor(){
		if (!pujas.isEmpty()) {
			return pujas.getLast();
		}else {
			return null;
		}
	}
	/**
	 * Metodo que muestra la puja mayor
	 * @return puja mayor
	 */
	public String PujaMayor() {
		return "La puja mayor es de: "+getPujaMayor();
	}
/**
 * 	Metodo para hacer una puja sobre la subasta. Nos pedira
 *  el usuario que realiza la puja y la cantidad por la que puja. 
 *  La puja es aceptada si: 
 *    a) la subasta esta abierta, 
 *    b) el credito del usuario que la realiza es suficiente para la cantidad por la que puja; 
 *    c) el usuario no es propietario de la subasta y 
 *    d) la cantidad es mayor que la cantidad de la puja mayor, si la hubiera. 
 *  Esta operacion acaba indicando si la puja ha sido aceptada  
 *  Si la puja se acepta, se construye una puja y se almacena en la lista de pujas
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
 * 	Metodo que permite pujar sin indicar la cantidad. solo se pide el usuario que la realiza. 
 *  La cantidad sera un euro mas que la cantidad de la puja mayor. 
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
 * 	Metodo para cerrar una subasta
 * @return true la puja se ha cerrado.
 */
	public boolean cerrar () {
		abierta=false;
		return true;
	}	
	
	
/**
 * 	Este metodo ejecuta la subasta haciendo el intercambio de credito entre 
 *  el usuario ganador y el usuario propietario. Se puede ejecutar 
 *  una subasta si se ha hecho alguna puja y está abierta. La ejecucion 
 *  consiste en restar el credito del usuario que ha realizado la puja mayor y 
 *  aumentar el credito del propietario de la subasta (por la cantidad de la puja mayor. 
 *  El metodo finaliza informando si la subasta ha podido ejecutarse o no (retorna un valor booleano).
 *  
 * @return true si la subasta ha podido ejecutarse y false en caso contrario
 */	
	public boolean ejecutar(){
			
		if (cerrar()==true) {
				
				Usuarios ganador = getPujaMayor().getPujador();
				
				double cantidad = getPujaMayor().getCantidad();
				
				propietario.incrementarCredito(cantidad);
				
				ganador.decrementarCredito(cantidad);
				
				abierta = false;
				
				return true;
		}		
		return false;	
	}
	
	
	/**
	 * Informacion completa de una subasta
	 * @return productor , propietario ,abierta, pujas, fecha de apertura de la subasta y fecha de cierre de la subasta
	 */
	@Override
	public String toString() {
		return getClass().getName() + " [producto=" + producto
									+ ", propietario=" + propietario.getNombre() 
									+ ", abierta=" + abierta
									+ ", pujas=" + pujas.size()
									+ ", Fecha de apertura de la subasta="+ tiempoSubasta.minusSeconds(tiempoAbierta)
									+ ", Fecha de cierre de la subasta="+ tiempoSubasta
									+ "]";
	}
}

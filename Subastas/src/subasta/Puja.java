package subasta;

import subasta.Usuarios;

/**
 * Una puja representa la cantidad de dinero que ofrece un usuario por 
 * el producto de una subasta
 * 
 * @author JoseRuso
 * @author Juan
 * @author Miriam
 *
 */
public class Puja {

	private final Usuarios pujador;
	private final double cantidad;
	/**
	 * 	Constructor de la clase puja
	 * @param pujador
	 * @param cantidad
	 */
	public Puja(Usuarios pujador, double cantidad) {
		this.pujador = pujador;
		this.cantidad = cantidad;
	}

	/**
	 * getters
	 * @return pujador y cantidad
	 */
	public Usuarios getPujador() {
		return pujador;
	}

	public double getCantidad() {
		return cantidad;
	}
	
	/**
	 * Información completa de la puja
	 * @return pujador y cantidad pujada
	 */
	@Override
	public String toString() {
		return "[pujador=" + pujador.getNombre() 
									+ ", cantidad=" + cantidad 
									+ "]";
	}
}

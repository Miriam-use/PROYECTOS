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
 * 	
 * @param pujador
 * @param cantidad
 */
	public Puja(Usuarios pujador, double cantidad) {
		this.pujador = pujador;
		this.cantidad = cantidad;
	}

	public Usuarios getPujador() {
		return pujador;
	}

	public double getCantidad() {
		return cantidad;
	}

	@Override
	public String toString() {
		return getClass().getName() + " [pujador=" + pujador.getNombre() 
									+ ", cantidad=" + cantidad 
									+ "]";
	}
}

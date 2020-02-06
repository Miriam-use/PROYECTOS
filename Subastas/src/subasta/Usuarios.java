package subasta;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import subasta.Subasta;

/**
 * Representa al usuario del sistema de subastas. Estos usuarios pueden pujar
 * por productos que ofrecen otros usuarios
 * 
 * @author JoseRuso
 * @author Juan
 * @author Miriam
 *
 */
public class Usuarios {

	private final String nombre;
	private double credito;
	private LinkedList<Subasta> subastasCreadas;

	
/**
 * 
 * @param nombre
 * @param credito
 */
	Usuarios(String nombre, double credito){
		this.nombre=nombre;
		this.credito=credito;
		this.subastasCreadas = new LinkedList<Subasta>();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getCredito() {
		return credito;
	}
	
	public List<Subasta> getSubastasCreadas() {
		return Collections.unmodifiableList(subastasCreadas);
	}
	
	public void addSubasta (Subasta subasta){
		subastasCreadas.add(subasta);
	}
	
	public void incrementarCredito(double cantidad){
		credito += cantidad;
	}

	public void decrementarCredito(double cantidad){
		credito -= cantidad;
	}
	
	public String getMostrar() {
		return "Intengrante de la subasta "+nombre+" con un credito de "+credito+" €";
	}
	
	@Override
	public String toString() {
		return getClass().getName() + " [nombre=" + nombre  
									+ ", credito="+ credito
									+" €, subastasCreadas="+subastasCreadas.size()
									+ "]";
	}
	
}

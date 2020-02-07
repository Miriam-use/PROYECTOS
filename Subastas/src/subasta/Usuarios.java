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
 * Constructor de la clase usuario
 * @param nombre
 * @param credito
 */
	public Usuarios(String nombre, double credito){
		this.nombre=nombre;
		this.credito=credito;
		this.subastasCreadas = new LinkedList<Subasta>();
	}
	/**
	 * Getters
	 * @return dato de cada metodo concreto
	 */
	public String getNombre() {
		return nombre;
	}
	
	public double getCredito() {
		return credito;
	}
	
	public List<Subasta> getSubastasCreadas() {
		return Collections.unmodifiableList(subastasCreadas);
	}
	
	/**
	 * Metodo para añadir una subasta
	 * @param subasta
	 */
	public void addSubasta (Subasta subasta){
		subastasCreadas.add(subasta);
	}
	
	/**
	 * Metodo para incrementar credito del usuario
	 * @param cantidad
	 */
	public void incrementarCredito(double cantidad){
		credito += cantidad;
	}
 
	/**
	 * Metodo para hacer mas bajo el credito
	 * @param cantidad
	 */
	public void decrementarCredito(double cantidad){
		credito -= cantidad;
	}
	
	/**
	 * Metodo para imprimir por pantalla la información del usarario
	 * @return Nombre y credito
	 */
	public String getMostrar() {
		return "Intengrante de la subasta "+nombre+" con un credito de "+credito;
	}
	
	/**
	 * Información completa de un usuario
	 * @return nombre, credito, subastas creadas
	 */
	@Override
	public String toString() {
		return getClass().getName() + " [nombre=" + nombre  
									+ ", credito="+ credito
									+", subastasCreadas="+subastasCreadas.size()
									+ "]";
	}
	
}

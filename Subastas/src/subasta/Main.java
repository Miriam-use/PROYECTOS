package subasta;

import java.time.LocalDate;
import java.util.LinkedList;

import subasta.Usuarios;
import subasta.Subasta;
/**
 * 
 * @author JoseRuso
 * @author Juan
 * @author Miriam
 *
 */
public class Main {

	public static void main(String[] args) {
		
		Usuarios juan = new Usuarios("Juan", 100);
		Usuarios pedro = new Usuarios("Pedro", 150);
		Usuarios enrique = new Usuarios("Enrique", 300);
		
		//-	Crea una subasta del producto "Teléfono Móvil" cuyo propietario sea el usuario Juan
		
		Subasta subasta = new Subasta("Teléfono Móvil", juan);
		
		//-	El usuario Pedro puja por esa subasta 100 euros.
		
		subasta.pujar(pedro, 100);
		
		//-	Muestra en la consola la puja mayor de la subasta (nombre del usuario y cantidad).
		
		
		System.out.println(subasta.getPujaMayor());
		
		//-	El usuario Enrique puja por esa subasta 50 euros.
		
		subasta.pujar(enrique, 50);
		
		//-	Muestra en la consola la puja mayor. Comprueba que esta segunda puja no ha sido acepta, ya que es menor que la primera.
		
		System.out.println(subasta.getPujaMayor());
				
		//-	Ejecuta la subasta.
				
		subasta.ejecutar();
		
		//-	El usuario Enrique puja de nuevo por esa subasta con 200 euros. Comprueba que no es aceptada, ya que la subasta ha sido cerrada.
		
		System.out.println(subasta.pujar(enrique, 200));
				
		//-	Crea una colección con los usuarios.
		
		LinkedList<Usuarios> usuarios = new LinkedList<Usuarios>();
			usuarios.add(juan);
			usuarios.add(pedro);
			usuarios.add(enrique);
				
		//-	Muestra por la consola los créditos de los tres usuarios. Observa que los créditos de Juan y Pedro han cambiado.
				
		for (Usuarios usuario : usuarios) {
			System.out.println("Credito de " + usuario.getNombre() + " = "+ usuario.getCredito());
		}		
				
		//-	Muestra las subastas de las que son propietarios los tres usuarios.
				
		for (Usuarios usuario : usuarios) {
			System.out.println("Subastas de " + usuario.getNombre() + " = " + usuario.getSubastasCreadas());
		}
	}

}

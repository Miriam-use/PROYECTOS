package subastaDAO;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import subasta.Usuarios;

public class MainDAO {

	static Scanner sc;
	static int seg;
	static subasta.Excepciones ex;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.out.println("--------------Bienvenidos a la primera Subasta del dia--------------"
				+ "\nEl subastador de hoy es Juan, subastando el producto Telefono Movil."
				+ "\nLos pujadores seran Pedro con un credito de 150 y Enrique con un credito de 300.");
		
		
		UsuariosDAO usuario = new UsuariosDAO();
					usuario.UsuariosDAO("Juan", 100);
		 			usuario.UsuariosDAO("Pedro", 150);
		 			usuario.UsuariosDAO("Enrique", 300);
		
		ex=new subasta.Excepciones(); 			
		 			
		//- Le pedimos cuanto tiempo estara abierta la subasta
						
		 	System.out.println("\nIntroduce en segundos el tiempo que la subasta estara abierta:");
		 	seg=ex.controlaInt();	
		
		//-	Crea una subasta del producto "Teléfono Móvil" cuyo propietario sea el usuario Juan
		
		SubastaDAO subasta = new SubastaDAO("Telefono Movil", usuario.usuario().get(0),seg);
		
		//-	El usuario Pedro puja por esa subasta 100 euros.
		
		if(subasta.pujar(usuario.usuario().get(1), 100, 0) == true) {
			System.out.println("Puja de Pedro: Aceptada");
		}else {
			System.out.println("Puja de Pedro: Rechazada");
		}
		
		TimeUnit.SECONDS.sleep(5);
		
		//-	El usuario Enrique puja por esa subasta 50 euros.
		
		if(subasta.pujar(usuario.usuario().get(2), 50, 0) == true) {
			System.out.println("Puja de Enrique: Aceptada");
		}else {
			System.out.println("Puja de Enrique: Rechazada");
		}
		
		TimeUnit.SECONDS.sleep(5);
		
		//- Cierra la subasta
		
		if(subasta.cerrar(0) == true) {
			System.out.println("\nSe ha cerrado la subasta");
		}else {
			System.out.println("\nLa subasta sigue abierta");
		}
		//-	Muestra en la consola la puja mayor de la subasta (nombre del usuario y cantidad).
		
		System.out.println("\nLa puja Mayor es: "+subasta.PujaMayor(0));
		
		TimeUnit.SECONDS.sleep(5);
		
		//-	El usuario Enrique puja de nuevo por esa subasta con 200 euros. Comprueba que no es aceptada, ya que la subasta ha sido cerrada.
		
		if(subasta.pujar(usuario.usuario().get(2), 200, 0) == true) {
			System.out.println("Puja de Enrique: Aceptada");
		}else {
			System.out.println("Puja de Enrique: Rechazada");
		}
		
		//-	Ejecuta la subasta.
		
		System.out.println("\nSe ha ejecutado la subasta "+subasta.ejecutarSubasta(0));
		
		//-	Crea una colección con los usuarios.
		
		LinkedList<Usuarios> usuarios = new LinkedList<Usuarios>();
		usuarios.add(usuario.usuario().get(0));
		usuarios.add(usuario.usuario().get(1));
		usuarios.add(usuario.usuario().get(2));
		
		//-	Muestra por la consola los créditos de los tres usuarios. Observa que los créditos de Juan y Pedro han cambiado.
		
		for(int i=0; i<3; i++) {
			System.out.println("Credito de "+usuario.getNombre(i)+" = "+usuario.getCredito(i));
		}
		
		for(int i=0; i<3; i++) {
			System.out.println("Subastas de "+usuario.getNombre(i)+" = "+usuario.CrearSubasta(i));
		}
	}

}

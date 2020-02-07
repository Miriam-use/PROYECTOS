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
		
		UsuariosDAO usuario = new UsuariosDAO();
					usuario.UsuariosDAO("Juan", 100);
		 			usuario.UsuariosDAO("Pedro", 150);
		 			usuario.UsuariosDAO("Enrique", 300);
		
		ex=new subasta.Excepciones(); 			
		 			
		//- Le pedimos cuanto tiempo estara abierta la subasta
						
		 	System.out.println("Introduce en segundos el tiempo que la subasta estara abierta:");
		 	seg=ex.controlaInt();	
		
		//-	Crea una subasta del producto "Teléfono Móvil" cuyo propietario sea el usuario Juan
		
		SubastaDAO subasta = new SubastaDAO("Telefono Movil", usuario.usuario().get(0),seg);
		
		//-	El usuario Pedro puja por esa subasta 100 euros.
		
		System.out.println("Puja de Pedro: "+subasta.pujar(usuario.usuario().get(1), 100, 0));
		
		TimeUnit.SECONDS.sleep(10);
		
		//-	El usuario Enrique puja por esa subasta 50 euros.
		
		System.out.println("Puja de Enrique: "+subasta.pujar(usuario.usuario().get(2), 50, 0));
		
		TimeUnit.SECONDS.sleep(10);
		
		//- Cierra la subasta
		
		System.out.println("\nSe ha cerrado la subasta "+subasta.cerrar(0));
		
		//-	Muestra en la consola la puja mayor de la subasta (nombre del usuario y cantidad).
		
		System.out.println("\n"+subasta.PujaMayor(0));
		
		TimeUnit.SECONDS.sleep(5);
		
		//-	El usuario Enrique puja de nuevo por esa subasta con 200 euros. Comprueba que no es aceptada, ya que la subasta ha sido cerrada.
		
		System.out.println("\nPuja de enrique "+subasta.pujar(usuario.usuario().get(2), 200, 0));
		
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

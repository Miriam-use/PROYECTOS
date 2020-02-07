package subasta;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
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
		
		static Scanner sc;
		static int seg;
		static Excepciones ex;
		
		public static void main(String[] args) throws InterruptedException, IOException {	
			
			//- Se instancian los tres usuarios
			
			Usuarios juan = new Usuarios("Juan", 100);
			Usuarios pedro = new Usuarios("Pedro", 150);
			Usuarios enrique = new Usuarios("Enrique", 300);
			
			//- Iniciamos la clase Excepcion
			ex=new Excepciones();
			
			//- Le pedimos cuanto tiempo estara abierta la subasta
			
			System.out.println("Introduce en segundos el tiempo que la subasta estara abierta:");
			seg=ex.controlaInt();
				
			//-	Crea una subasta del producto "Teléfono Móvil" cuyo propietario sea el usuario Juan
			
			Subasta subasta = new Subasta("Telefono Movil", juan,seg);
			
			//-	El usuario Pedro puja por esa subasta 100 euros.
			
			System.out.println("Puja de Pedro: "+subasta.pujar(pedro, 100));
			
			//añadimos 10 segundos de retardo
			TimeUnit.SECONDS.sleep(10);
			
			//-	El usuario Enrique puja por esa subasta 50 euros.
			
			System.out.println("Puja de enrique: "+subasta.pujar(enrique, 50));
			
			TimeUnit.SECONDS.sleep(10);
			
			//- Cierra la subasta
			
			System.out.println("\nSe ha cerrado la subasta "+subasta.cerrar());
			
			//-	Muestra en la consola la puja mayor de la subasta (nombre del usuario y cantidad).
			
			System.out.println("\n"+subasta.PujaMayor());
			
			TimeUnit.SECONDS.sleep(5);
			
			//-	El usuario Enrique puja de nuevo por esa subasta con 200 euros. Comprueba que no es aceptada, ya que la subasta ha sido cerrada.
			
			System.out.println("\nPuja de enrique "+subasta.pujar(enrique, 200));
			
			//-	Ejecuta la subasta.
			
			System.out.println("\nSe ha ejecutado la subasta "+subasta.ejecutar());
			
			//-	Crea una colección con los usuarios.
			
			LinkedList<Usuarios> usuarios = new LinkedList<Usuarios>();
			usuarios.add(juan);
			usuarios.add(pedro);
			usuarios.add(enrique);
			
			//-	Muestra por la consola los créditos de los tres usuarios. Observa que los créditos de Juan y Pedro han cambiado.
			
			for (Usuarios usuario : usuarios) {
				System.out.println("Credito de " + usuario.getNombre() + " = "+ usuario.getCredito()+" €");
			}
			
			// - fol usando lambda
			
			// - usuarios.stream().forEach(u -> System.out.println("Credito de " + u.getNombre() + " = "+ u.getCredito()+" €"));
					
			//-	Muestra las subastas de las que son propietarios los tres usuarios.
					
			for (Usuarios usuario : usuarios) {
				System.out.println("Subastas de " + usuario.getNombre() + " = " + usuario.getSubastasCreadas());
			}
			
			// - fol usando lambda
			
			//- usuarios.stream().forEach(u -> System.out.println("Subasta de " + u.getNombre() + " = "+ u.getSubastasCreadas()));
			
			
			
//----------------------------------------------------------------------------------------------------------------------------------------------------------			
			
			//Ejemplo con el menu
			
			/*
			sc = new Scanner(System.in);
			
			int opcion;
			do {
				// Al inicio de cada iteración mostramos el menú, y recogemos la opción
				menu();
				opcion = Integer.parseInt(sc.nextLine());
				switch (opcion) {
				case 1:
					subasta.pujar(pedro, 100);
					break;
				case 2:
					subasta.pujar(enrique, 50);
					break;
				case 3:
					subasta.cerrar();
					break;
				case 4:
					subasta.pujar(enrique, 200);
					break;
				case 5:
					subasta.ejecutar();
					break;
				case 6:
					LinkedList<Usuarios> usuarios = new LinkedList<Usuarios>();
					usuarios.add(juan);
					usuarios.add(pedro);
					usuarios.add(enrique);
					for (Usuarios usuario : usuarios) {
						System.out.println("Credito de " + usuario.getNombre() + " = "+ usuario.getCredito()+" €");
					}		
							
					//-	Muestra las subastas de las que son propietarios los tres usuarios.
							
					for (Usuarios usuario : usuarios) {
						System.out.println("Subastas de " + usuario.getNombre() + " = " + usuario.getSubastasCreadas());
					}
					break;
				case 0:
					System.out.println("Ha finalizado ");
					break;
				default:
					System.out.println("Opcion no valida. Introduzca una opcion valida (0-6), por favor.");
				}
			} while (opcion != 0);
			sc.close();
		}
		/
		 * METODO QUE IMPRIME EL MENU
		public static void menu() {
			System.out.println("SUBASTA NERVION SALESIANAS");
			System.out.println("===================");
			System.out.println("1. Realizar puja (Pedro)");
			System.out.println("2. Realizar puja (Enrique)");
			System.out.println("3. Cerrar subasta");
			System.out.println("4. Realizar puja fuera de plazo (Enrique)");
			System.out.println("5. Ejecutar subasta");
			System.out.println("6. Consultar situación");
			System.out.println("0. Salir");
		}
		*/
	}
}

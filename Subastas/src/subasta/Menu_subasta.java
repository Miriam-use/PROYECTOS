package subasta;
import java.time.LocalTime;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import subasta.Usuarios;
import subasta.Subasta;

public class Menu_subasta {

	static Scanner sc;
	
	public static void main(String[] args) throws InterruptedException {	
		Usuarios juan = new Usuarios("Juan", 100);
		Usuarios pedro = new Usuarios("Pedro", 150);
		Usuarios enrique = new Usuarios("Enrique", 300);
		
		System.out.println("Inserte el tiempo es segundos que quiere que dure la subasta en segundos");
		sc = new Scanner(System.in);
		long sec=sc.nextLong();
	
		LocalTime time = LocalTime.now();
		LocalTime time1 = time.plusSeconds(sec);
		
		Subasta subasta = new Subasta("Telefono Movil", juan);

		System.out.println("Puja de Pedro: "+subasta.pujar(pedro, 100));
		
		TimeUnit.SECONDS.sleep(29);
		
		if(LocalTime.now().isBefore(time1)) {
			System.out.println("Se ha cerrado la subasta ");
			subasta.cerrar();
		}
		
		System.out.println("Puja de enrique: "+subasta.pujar(enrique, 50));
		
		TimeUnit.SECONDS.sleep(29);
		
		if(LocalTime.now().isBefore(time1)) {
			System.out.println("Se ha cerrado la subasta ");
			subasta.cerrar();
		}
		
		
		
		
		System.out.println("Puja de enrique "+subasta.pujar(enrique, 200));
		if(LocalTime.now().isBefore(time1)) {
			System.out.println("Se ha cerrado la subasta ");
			subasta.cerrar();
		}
		System.out.println("Se ha ejecutado la subasta "+subasta.ejecutar());
		
		
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

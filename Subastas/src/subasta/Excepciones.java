package subasta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Excepciones {

	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	boolean error = false;

	public int controlaInt() throws IOException {
	int entero = 0;
	do {
	try {
	entero = Integer.parseInt(entrada.readLine());
	error = false;
	} catch (NumberFormatException e) {
	// TODO: handle exception
	System.out.println("Valor no válido");
	error = true;
	}
	} while (error);
	return entero;
	}

	public double controlaDouble() throws IOException {
	double entero = 0;
	do {
	try {
	entero = Double.parseDouble(entrada.readLine());
	error = false;
	} catch (NumberFormatException e) {
	// TODO: handle exception
	System.out.println("Valor no válido, vuelva a introducirlo");
	error = true;
	}
	} while (error);
	return entero;
	}
	
	
}

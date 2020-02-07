package subastaDAO;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import subasta.Subasta;
import subasta.Usuarios;

public class UsuariosDAO {

	List<Usuarios> usuario;
	SubastaDAO subasta;
	
	public UsuariosDAO() {
		usuario=new LinkedList();
	}
	public List<Usuarios> usuario(){
		return usuario;
	}
	
	public void UsuariosDAO(String nombre, double credito) {

		this.usuario.add(new Usuarios(nombre, credito));
	}
	
	public void incrementarCredito(double cantidad) {
		((Usuarios) usuario).incrementarCredito(cantidad);
	}
	
	public void decrementarCredito(double cantidad) {
		((Usuarios) usuario).decrementarCredito(cantidad);
	}
	
	public List<Subasta> CrearSubasta(int i) {
		return usuario.get(i).getSubastasCreadas();
	}
	
	public String getNombre(int i) {
		return usuario.get(i).getNombre();
	}
	
	public double getCredito(int i) {
		return usuario.get(i).getCredito();
	}
}

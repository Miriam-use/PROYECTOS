package subastaDAO;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import subasta.Puja;
import subasta.Usuarios;

public class PujaDAO {

	List<Puja> pujas;
	
	public PujaDAO() {
		pujas=new LinkedList();
	}
	
	public PujaDAO(Usuarios pujador, double cantidad) {
		this.pujas.add(new Puja(pujador, cantidad));
	}
	
	public boolean isEmpty() {
		return pujas.isEmpty();
	}
	
	public Puja getLast() {
		return ((Deque<Puja>) pujas).getLast();
	}
}

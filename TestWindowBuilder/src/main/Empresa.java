package main;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.security.auth.login.AccountException;

public class Empresa implements Serializable {
	private static final long serialVersionUID = 4815693014953825716L;
	
	
	
	private Map<String, String> credenciales = new HashMap<String, String>();
	public Empresa() {
		credenciales.put("admin", "admin");
		credenciales.put("1", "1");
		credenciales.put("user", "password");
	}
	public boolean ingresar(String user, String pass) throws AccountException{
		
		if(credenciales.get(user) == null)
			throw new AccountException("El usuario no existe");
		else if(credenciales.get(user).equals(pass) == false)
			throw new AccountException("La contraseña es incorrecta");
		else
			return true;
	}
	public Set<String> verUsuarios() {
		return credenciales.keySet();
	}
	public boolean agregarUsuario(String user, String pass) {
		if (credenciales.put(user, pass) == null)
			return true;
		else
			return false;
	}
	public boolean quitarUsuario(String user, String pass) {
		
		if (credenciales.remove(user) == null)
			return true;
		else
			return false;
	}
	public boolean modificarUsuario(String oldUser, String oldPass, String newUser, String newPass) {
		
		if (quitarUsuario(oldUser, oldPass))
		{
			agregarUsuario(newUser, newPass);
			return true;
		}
		else
			return false;
	}
	
	
	private Set<Cliente> listaSet = new HashSet<>();
	public Set<Cliente> getListaSet(){
		return listaSet;
	}
	public boolean listaSetAgregar(Cliente c) {
		boolean agregado = false;
		agregado = listaSet.add(c);
		return agregado;
	}
	public boolean listaSetQuitar(int id) {
		Iterator<Cliente> iterator = listaSet.iterator();
	    while (iterator.hasNext()) {
	        Cliente cliente = iterator.next();
	        if (cliente.getId().equals(id)) {
	            iterator.remove();
	            return true;
	        }
	    }
	    return false;
	}
	public boolean listaSetModificar(Cliente c) {
		for(Cliente obj : listaSet)
		{
			if (obj.getId().equals(c.getId()))
	        {
	        	obj.setDni(c.getDni());
	        	obj.setNombre(c.getNombre());
	            return true;
	        }
	    }
	    return false;
	}
	int idCont = 0, nomCont = 1;
	public void listaSetAgregarRandoms() {
		SecureRandom rnd = new SecureRandom();
		int cont = 0;
		while(cont != 10) {
			//System.out.println("cont = "+cont+" ||| idCont = "+idCont);
			if(listaSet.add(new Cliente("Nombre"+nomCont, rnd.nextLong(30000000,60000000), ++idCont) ))
			{
				nomCont++;
				cont++;
			}
		}
	}
	
	
	
	//private TreeMap<Integer, Cliente> listaTreeMap = new TreeMap<>();
	private Map<Integer, Cliente> listaMap = new HashMap<>();
	
	public boolean listaMapAgregar(int id, Cliente c) {
		
		if (listaMap.put(id, c) == null)
			return true;
		else return false;
	}
	public boolean listaMapQuitar(int id) {
		if (listaMap.remove(id) == null)
			return false;
		else return true;
	}
	public boolean listaMapModificar(int id, Cliente c) {
		Cliente obj = listaMap.get(id);
		if (obj == null)
			return false;
		
		obj.setDni(c.getDni());
		obj.setNombre(c.getNombre());
		return true;
	}
	public Map<Integer, Cliente> getListaMap() {
		return listaMap;
	}
	
	
	
	
	public void mapear() {
		Map<Integer, String> mapaHash = new HashMap<>();
		TreeMap<Integer, String> tMap;
		
		String dias[]={"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
		for(int i=0; i<7; i++)
			mapaHash.put(i, dias[i]);
		
		tMap = new TreeMap<Integer, String>(mapaHash);
		System.out.println("Claves del treemap: " + tMap.keySet());
		System.out.println("Valores del tree map: " + tMap.values());
		
		if(mapaHash.put(8,"pto") == null)
			System.out.println("Cargado");
		else System.out.println("No cargado");
		
		System.out.println(tMap.get(1));
		tMap.remove(1);
		
		System.out.println("Claves del treemap: " + tMap.keySet());
		System.out.println("Valores del tree map: " + tMap.values());
	}
	
	public void agregarClientesSet()
	{
		Set<Cliente> listaHashSet = new HashSet<>();
		Set<Cliente> listaTreeSet = new TreeSet<>();
		for (int i = 0; i < 10; i++)
			if(listaHashSet.add(new Cliente("Cli"+i, 40000000L+i, i+1)))
				System.out.println("Agregado");
			else System.out.println("No agregado");
		
		
		// implementa equals+hashCode o en su defecto compareTo
		System.out.println("------ HashSet ------");
		listaHashSet.forEach(System.out::println);
		
		//solo implementa compareTo
		System.out.println("------ TreeSet ------");
		listaTreeSet.forEach(System.out::println);
	}
	
	
	
	
	
	
	
	private List<Cliente> listaClientes = new ArrayList<>();
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	
	private int id = 0;
	public boolean agregarCliente(String nombre, Long dni)
	{
		System.out.println("id:"+id+1);
		Cliente c = new Cliente(nombre, dni, ++id);
		boolean yaExiste = false;
		for(Cliente cli : listaClientes)
		{
			if(cli.getDni() == c.getDni())
			{
				yaExiste = true;
				break;
			}
		}
		if(!yaExiste)
			listaClientes.add(c);
		return !yaExiste;
	}
	
	public boolean quitarCliente(Long dni)
	{
		boolean borrado = false;
		for(Cliente cli : listaClientes)
		{
			if(cli.getDni() == dni)
			{
				listaClientes.remove(cli);
				borrado = true;
				System.out.println("Borrado");
				break;
			}
		}
		return borrado;
	}
}

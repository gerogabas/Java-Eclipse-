package main;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable, Comparable<Cliente> {
	private static final long serialVersionUID = -3524527059673634263L;
	
	private String nombre;
	private Integer id;
	private Long dni;
	
	public Cliente(String nombre, Long dni, int id)
	{
		
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public Long getDni() {
		return dni;
	}
	public Integer getId() {
		return id;
	}
	// *************************** criterio de orden *******************************************************
	@Override
	public int compareTo(Cliente o) {
		return Integer.compare(this.id, o.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Cliente [ id=" + id + ", nombre=" + nombre + ", dni=" + dni + "]";
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}
	
	
	
}

package application;

import java.time.LocalDate;

public class Persona {
	
	public static enum Genero {
		MASCULINO, FEMENINO, ALTERNATIVO;
	}
	
	public static enum Estado{
		ACTIVO, INACTIVO;
	}
	
	private String nombre;
	private LocalDate fechaNacimiento;
	private Genero genero;
	private String email;
	private Estado estado;


	
	
	public Persona(String nombre, LocalDate fechaNacimiento, Genero genero, String email) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.email = email;
		this.estado = Estado.ACTIVO;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public Genero getGenero() {
		return genero;
	}


	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + ", email="
				+ email + "Estado: "+ estado + "]";
	}
	
	
	
	
}

package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RedSocial {
	List<Persona> miembros = new ArrayList<Persona>();
	
	
	//Enfoque 1: Crear metodos por criterio
	public List<Persona> buscarPersonasPorGenero(List<Persona> miembros, Persona.Genero genero)
	{
		List<Persona> personasSeleccionadas = new ArrayList<Persona>();
		System.out.println("Las personas con el genero " + genero + "son: ");
		for (Persona p: miembros)
		{
			if(p.getGenero().equals(genero))
			{
				personasSeleccionadas.add(p);
				System.out.println(p);
			}
		}
		return personasSeleccionadas;
	}
	
	public List<Persona> buscarPersonasMayoresDeCiertaEdad(List<Persona> miembros, int edad)
	{
		List<Persona> personasSeleccionadas = new ArrayList<Persona>();
		System.out.println("Las personas de " + edad + "son: ");
		for (Persona p: miembros)
		{
			if(edad < LocalDate.now().getYear() - p.getFechaNacimiento().getYear())
			{
				personasSeleccionadas.add(p);
				System.out.println(p);
			}
		}
		return personasSeleccionadas;
	}
	
	
	//Enfoque 2: Crear metodos por criterios generalizados
	
}

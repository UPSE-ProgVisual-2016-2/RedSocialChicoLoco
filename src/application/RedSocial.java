package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RedSocial {
	List<Persona> miembros = new ArrayList<Persona>();
	
	
	//Enfoque 1: Crear metodos por criterio
	public static List<Persona> buscarPersonasPorGenero(List<Persona> miembros, Persona.Genero genero)
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
	
	public static List<Persona> buscarPersonasMayoresDeCiertaEdad(List<Persona> miembros, int edadAEvaluar)
	{
		List<Persona> personasSeleccionadas = new ArrayList<Persona>();
		System.out.println("Las personas de " + edadAEvaluar + "son: ");
		for (Persona p: miembros)
		{
			if(edadAEvaluar-1 < LocalDate.now().getYear() - p.getFechaNacimiento().getYear())
			{
				//int meses = LocalDate.now().getMonthValue()-p.getFechaNacimiento().getMonthValue();
				//if(meses > 0)
				{
					personasSeleccionadas.add(p);
					System.out.println(p);	
				}
				
			}
		}
		return personasSeleccionadas;
	}
	
	
	//Enfoque 2: Crear metodos por criterios generalizados
	public static List<Persona> buscarPersonasPorRangoEdad(List<Persona> miembros, int edadMin, int edadMax)
	{
		List<Persona> personasSeleccionadas = new ArrayList<Persona>();
		System.out.println("Las personas entre las edades " + edadMin + " y " + edadMax + "son: ");
		for (Persona p: miembros)
		{
			int edadAprox = LocalDate.now().getYear() - p.getFechaNacimiento().getYear();
			if(edadMin<=edadAprox && edadMax>=edadAprox)
			{
					personasSeleccionadas.add(p);
					System.out.println(p);							
			}
		}
		return personasSeleccionadas;
	}
	
	//Enfoque 3: Segun criterios
	public static List<Persona> buscarPersonasPorCriterioGeneral(List<Persona> miembros, Criterio criterio)
	{
		List<Persona> personasSeleccionadas = new ArrayList<Persona>();
		System.out.println("Las personas seleccionadas segun el criterio " + criterio.toString() + "son: ");
		for(Persona p: miembros)
		{
			if(criterio.verificar(p))
			{
				personasSeleccionadas.add(p);
				System.out.println(p);
			}
		}
		return personasSeleccionadas;
	}
}

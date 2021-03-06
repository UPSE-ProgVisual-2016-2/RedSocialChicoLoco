package application;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import application.Persona.Estado;

public class SimuladorRedSocialCL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona p1 = new Persona("Alina", LocalDate.of(1996, 12, 11), Persona.Genero.FEMENINO, "Alina@ChicoLocoNetwork.org");
		Persona p2 = new Persona("Blas", LocalDate.of(1997, 2, 15), Persona.Genero.MASCULINO, "blas@ChicoLocoNetwork.org");
		Persona p3 = new Persona("Julian", LocalDate.of(1972, 6, 5), Persona.Genero.ALTERNATIVO, "julian@ChicoLocoNetwork.org");
		Persona p4 = new Persona("Milf", LocalDate.of(1980, 3, 9), Persona.Genero.FEMENINO, "milf@ChicoLocoNetwork.org");
		Persona p5 = new Persona("Viejo Verde", LocalDate.of(1947, 2, 11), Persona.Genero.MASCULINO, "viejoverde@ChicoLocoNetwork.org");
		Persona p6 = new Persona("Kerly Potter", LocalDate.of(1998, 1, 1), Persona.Genero.FEMENINO, "kerly@ChicoLocoNetwork.org");
		Persona p7 = new Persona("Pelado Salchipapa", LocalDate.of(2004, 1, 10), Persona.Genero.MASCULINO, "pelaosachipapa@ChicoLocoNetwork.org");
		Persona p8 = new Persona("Chikitap Tucositap favoritak princess <3", LocalDate.of(2003, 12, 6), Persona.Genero.FEMENINO, "tucositap@ChicoLocoNetwork.org");
		Persona p9 = new Persona("Viejo Depredador", LocalDate.of(1953, 2, 11), Persona.Genero.MASCULINO, "machocastigadorlatino69@ChicoLocoNetwork.org");
		Persona p10 = new Persona("Princeso Andrew", LocalDate.of(1991, 5, 16), Persona.Genero.ALTERNATIVO, "princesoAndrew@upse.edu.ec");
		Persona p11 = new Persona("La Senora Candy", LocalDate.of(1970, 9, 3), Persona.Genero.FEMENINO, "Candysensacion@ChicoLocoNetwork.org");
		
		
		
		List<Persona> miembrosChicoLocoNetwork = new ArrayList<Persona>();
		miembrosChicoLocoNetwork.add(p1);
		miembrosChicoLocoNetwork.add(p2);
		miembrosChicoLocoNetwork.add(p3);
		miembrosChicoLocoNetwork.add(p4);
		miembrosChicoLocoNetwork.add(p5);
		miembrosChicoLocoNetwork.add(p6);
		miembrosChicoLocoNetwork.add(p7);
		miembrosChicoLocoNetwork.add(p8);
		miembrosChicoLocoNetwork.add(p9);
		miembrosChicoLocoNetwork.add(p10);
		miembrosChicoLocoNetwork.add(p11);
		
		System.out.println("***********Funciones***********");
		System.out.println("Enfoque 1: ");
		RedSocial.buscarPersonasMayoresDeCiertaEdad(miembrosChicoLocoNetwork, 20);
		
		System.out.println("Enfoque 2: ");
		RedSocial.buscarPersonasPorRangoEdad(miembrosChicoLocoNetwork, 15, 45);
		
		System.out.println("Enfoque 3: ");
		VerificadorMujeresJovenes vmj = new VerificadorMujeresJovenes();
		RedSocial.buscarPersonasPorCriterioGeneral(miembrosChicoLocoNetwork, vmj);
		
		System.out.println("Enfoque 4: ");
		RedSocial.buscarPersonasPorCriterioGeneral(miembrosChicoLocoNetwork, new Criterio() {
			
			@Override
			public boolean verificar(Persona p) {
				int edad = LocalDate.now().getYear() - p.getFechaNacimiento().getYear();
				if(edad>=50 && p.getGenero().equals(Persona.Genero.MASCULINO))
				{
					return true;
				}
				return false;
			}
			
			@Override
			public String toString()
			{
				return "Viejo verde ";
			}
		});
		
		RedSocial.buscarPersonasPorCriterioGeneral(miembrosChicoLocoNetwork, new Criterio() {
			
			@Override
			public boolean verificar(Persona p) {
				int edad = LocalDate.now().getYear() - p.getFechaNacimiento().getYear();
				if(edad>=40 && p.getGenero().equals(Persona.Genero.FEMENINO))
				{
					return true;
				}
				return false;
			}
			
			@Override 
			public String toString()
			{
				return "Mujeres maduras ";
			}
		}  );
		
		System.out.println("Enfoque 5: ");
		//Enfoque 5: Expresiones Lambda
		RedSocial.buscarPersonasPorCriterioGeneral(miembrosChicoLocoNetwork, 
					(Persona p) -> p.getGenero() == Persona.Genero.FEMENINO);
		
		RedSocial.buscarPersonasPorCriterioGeneral(miembrosChicoLocoNetwork,
				p -> p.getGenero().equals(Persona.Genero.FEMENINO));
		
		
		RedSocial.buscarPersonasPorCriterioGeneral(miembrosChicoLocoNetwork, 
				(Persona p) -> p.getGenero() == Persona.Genero.MASCULINO 
				&& (p.getFechaNacimiento().getYear() 
						- Period.between(LocalDate.now(), p.getFechaNacimiento()).getYears()) > 18);
		
		RedSocial.buscarPersonasPorCriterioGeneral(miembrosChicoLocoNetwork, 
				p -> p.getGenero() == Persona.Genero.MASCULINO 
				&& (p.getFechaNacimiento().getYear() 
						- Period.between(LocalDate.now(), p.getFechaNacimiento()).getYears()) > 18);
		
		System.out.println("Enfoque 5.4 Lambda con Bloque de codigo: ");
		RedSocial.buscarPersonasPorCriterioGeneral(miembrosChicoLocoNetwork, 
				p -> { if(p.getGenero().equals(Persona.Genero.MASCULINO) &&
						(LocalDate.now().getYear() - p.getFechaNacimiento().getYear())>35)
							{
								System.out.println("Viejo Verde");
								return true;
							}
						return false;});
		
		
		System.out.println("Enfoque 6: ");
		
		//Enfoque 6: Expresiones Lambda con Interfaces funcionales Standard
		//Usamos la interfaz Predicate<T> en llugar de la interfaz Criterio
		//Hombres mayores de edad
		
		RedSocial.buscarPersonaPorCriterioIntefazFuncionalStandard(miembrosChicoLocoNetwork, 
				p -> p.getGenero().equals(Persona.Genero.MASCULINO));
		
		
		System.out.println("Enfoque 7: ");
		RedSocial.buscarPersonasPorCriterioAplicandoFuncion(miembrosChicoLocoNetwork,
				p -> p.getFechaNacimiento().getYear()>2000,
				p -> {p.setEstado(Estado.INACTIVO);});
		
		System.out.println("Enfoque 7.1: ");
		
		//Enfoque 7: Usando mas Lambdas con interfaces funcionales standard
		//Agregamos la interfaz funcional block para poder especificar mas acciones
		RedSocial.buscarPersonasPorCriterioEjecutandoFuncion(miembrosChicoLocoNetwork,
				p -> (p.getFechaNacimiento().getYear()>1993 
				 && p.getFechaNacimiento().getYear()<1998) ,
				p -> {System.out.println("A mesa electoral : " + p.getNombre());
						});
		
		System.out.println("Enfoque 7.1: Dia de la mujer");
		RedSocial.buscarPersonasPorCriterioEjecutandoFuncion(miembrosChicoLocoNetwork,
				p -> (p.getGenero().equals(Persona.Genero.FEMENINO)), 
				m -> {System.out.println("ChicoLoco se preocupa por las mujeres, feliz dia " + m.getNombre());});
		
		//Ahora hagamos enviemos una expresion lambda que imprima un mensaje que invite a salir a las
		//personas de la red social que cumplan con nuestros criterios (genero y edades preferidas)
		//No lo nieguen todos tienen preferencias.
		
		System.out.println("Enfoque 7.2: ");
		RedSocial.buscarPersonasPorCriterioEjecutandoFuncionMapper(miembrosChicoLocoNetwork, 
				p -> (p.getFechaNacimiento().getYear()<1998), 
				p -> p.getEmail(), 
				email -> System.out.println("El email a spamear es: " + email));
		
		System.out.println("Enfoque 7.2 en clase: ");
		RedSocial.filtrarPersonasPorCriterioObteniendoEmailYProcesandoEmail(
				miembrosChicoLocoNetwork, 
				p -> p.getGenero().equals(Persona.Genero.ALTERNATIVO), 
				p -> p.getNombre() + " " + p.getFechaNacimiento().toString(), 
				s -> System.out.println(s + " eres aceptado aqui. Todos somos iguales a los ojos de JAVA."));

		System.out.println("Enfoque 7.2 en clase: ");
		RedSocial.filtrarPersonasPorCriterioObteniendoEmailYProcesandoEmail(
				miembrosChicoLocoNetwork, 
				p -> p.getGenero().equals(Persona.Genero.ALTERNATIVO), 
				p -> p.getEmail(), 
				s -> ManejadoraEmail.procesarEmail(s));
		
		System.out.println("Enfoque 8: ");
		RedSocial.procesarElementos(miembrosChicoLocoNetwork, 
				p -> p.getGenero() == Persona.Genero.MASCULINO, 
				p -> p.getNombre(), 
				email -> System.out.println("El email a spamear es: " + email));
		
		//Enfoque 9: Aggregate Operations
		System.out.println("Enfoque 9: Streaming de datos");
		miembrosChicoLocoNetwork
			.stream()
			.filter( p -> p.getEstado().equals(Persona.Estado.ACTIVO))
			.map( p -> p.getEmail())
			.forEach(email -> System.out.println(email));
		
		//Enfoque 9: Aggregate Operations (San Valentin)
		miembrosChicoLocoNetwork
			.stream()
			.filter(p -> p.getGenero().equals(Persona.Genero.MASCULINO))
			.forEach(p -> System.out.println("Oye " + p.getNombre() + " consigue un regalo de San Valentin si quieres que tu novia te de lo tuyo!"));
		
	}
	
	
}

package application;

import java.io.LineNumberInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

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
	
	//Enfoque 6: Usando Interfaces Funcionales Standard
	public static List<Persona> buscarPersonaPorCriterioIntefazFuncionalStandard(List<Persona> miembros,
			Predicate<Persona> predicateCriterio)
	{
		List<Persona> personasSeleccionadas = new ArrayList<Persona>();
		for(Persona p: miembros)
		{
			if(predicateCriterio.test(p))
			{
				personasSeleccionadas.add(p);
				System.out.println(p);
			}
		}
		return personasSeleccionadas;
		
	}
	
	//Enfoque 7.1: Usando mas Interfaces Funcionales Standard para proveer cualquier funcionalidad
	//Este metodo recibe cualquier cosa que implemente la interfaz consumer, 
	//la cual recibe un objeto persona y retorna void
	//Esto me permitira enviar como parametro cualquier funcion 
	//que tenga como parametro una persona y ejecute una accion sobre ella (sin retornar nada).
	public static List<Persona> buscarPersonasPorCriterioAplicandoFuncion(
			List<Persona> miembros,
			Predicate<Persona> predicadoACumplir,
			Consumer<Persona> funcionAAplicar)
	{
		List<Persona> seleccionadosAplicadaFuncion = new ArrayList<Persona>();
		for(Persona p:miembros)
		{
			if(predicadoACumplir.test(p))
			{
				funcionAAplicar.accept(p);
				seleccionadosAplicadaFuncion.add(p);
				System.out.println(p);
			}
		}
		return seleccionadosAplicadaFuncion;
		
	}
	
	public static List<Persona> buscarPersonasPorCriterioEjecutandoFuncion(List<Persona> miembros,
			Predicate<Persona> predicateCriterio, Consumer<Persona> funcion)
	{
		List<Persona> personasSeleccionadas = new ArrayList<Persona>();
		for(Persona p:miembros)
		{
			if(predicateCriterio.test(p))
			{
				funcion.accept(p);
				personasSeleccionadas.add(p);
				System.out.println(p);
			}
		}
		return personasSeleccionadas;
	}
	
	
	public static List<String> filtrarPersonasPorCriterioObteniendoEmailYProcesandoEmail(
			List<Persona> miembros,
			Predicate<Persona> predicado,
			Function<Persona, String> funcionMapeadora,
			Consumer<String> consumidora)
	{
		List<String> stringProcesados = new ArrayList<String>();
		
		for(Persona p: miembros)
		{
			if(predicado.test(p))
			{
				String s = funcionMapeadora.apply(p);
				consumidora.accept(s);
				stringProcesados.add(s);
			}
		}
		return stringProcesados;
	}
	
	//Enfoque 7.2: Usando mas Interfaces Funcionales Standard para proveer cualquier funcionalidad
	//Este metodo recibe cualquier cosa que implemente la interfaz consumer, 
	//la cual recibe un objeto persona y retorna void
	//Esto me permitira enviar como parametro cualquier funcion 
	//que tenga como parametro una persona y ejecute una accion sobre ella (sin retornar nada).
	public static List<Persona> buscarPersonasPorCriterioEjecutandoFuncionMapper(List<Persona> miembros,
				Predicate<Persona> predicateCriterio, 
				Function<Persona, String> funcionMapper,
				Consumer<String> funcionConsumidora)
		{
			List<Persona> personasSeleccionadas = new ArrayList<Persona>();
			for(Persona p:miembros)
			{
				if(predicateCriterio.test(p))
				{
					String email = funcionMapper.apply(p);
					funcionConsumidora.accept(email);
					personasSeleccionadas.add(p);
					System.out.println(p);
				}
			}
			return personasSeleccionadas;
		}
	
	/**
	 * Enfoque 8: Una funcion general para procesar cualquier tipo de elementos y
	 * la cual recibe cualquier tipo de implementacion de predicado para evaluar criterio
	 * recibe cualquier mapper para aplicar a los elementos que cumplen el criterio
	 * y una funcion consumidora que se ejecuta sobre los resultados de ese mapeo. Visijue!
	 * @param elementos : Lista de Elementos
	 * @param predicateGeneral : Predicado (a cumplir)
	 * @param functionMapper : Funcion a aplicar a los elementos que cumplen con el predicado y que retorna un resultado
	 * @param funcionConsumidora: Funcion que se ejecuta sobre el resultado del mapeo y que no retorna nada
	 * @return Lista de Elementos sobre los que se aplico el Predicado
	 */
	public static <X, Y> void procesarElementos( Iterable<X> elementos,
			Predicate<X> predicateGeneral,
			Function<X,Y> functionMapper, 
			Consumer<Y> funcionConsumidora)
	{
		//List<X> elementosSeleccionados = new ArrayList<X>();
		for(X x: elementos)
		{
			if(predicateGeneral.test(x))
			{
				Y resultadoMap = functionMapper.apply(x);
				funcionConsumidora.accept(resultadoMap);
				//elementosSeleccionados.add(x);
			}
		}
		//return elementosSeleccionados;
	}
	
	}

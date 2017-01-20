package application;

import java.time.LocalDate;

public class VerificadorPersonasAdultas implements Criterio {

	@Override
	public boolean verificar(Persona p) {
		int edad = LocalDate.now().getYear() - p.getFechaNacimiento().getYear();
		
		if(edad>18)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public String toString()
	{
		return "Personas adultas (mayores a 18)";
	}
}

package application;

import java.time.LocalDate;

public class VerificadorMujeresJovenes implements Criterio {

	@Override
	public boolean verificar(Persona p) {
		if(p.getGenero().equals(Persona.Genero.FEMENINO))
		{
			int edad = LocalDate.now().getYear() - p.getFechaNacimiento().getYear();
			if(edad>18 && edad<26)
			{
				return true;
			}			
		}
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String toString()
	{
		return "Mujeres jovenes entre las edades de 18 y 25";
	}

}

package application;

public class ManejadoraEmail {
	
	public static void procesarEmail(String email)
	{
		//llamada salvaje al servidor
		String mensaje = "El email ... " + email + " esta siendo procesado";
		System.out.println(mensaje);
		
		email = email.toLowerCase();
		email = email.trim();
		String usuario = email.substring(0, email.indexOf('@'));
		String dominio = email.substring(email.indexOf('@')+1);
		
		if(dominio.equals("upse.edu.ec"))
		{
			System.out.println("Bloqueado, este dominio siempre tiene virus!");
		}else{
			System.out.println("Si no es de la upse el email, entonces si confio");
			System.out.println("El usuario es " + usuario);
		}
				
	}
}

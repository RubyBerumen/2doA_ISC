import java.util.Scanner;
import java.util.Random;

public class Juego {

	public static void main(String[] args) {
		
		System.out.println("Programa que simula el juego del ahorcado \n"
				+ "donde el segundo jugador es la computadora\n");
		
		Scanner entrada = new Scanner(System.in);
		Random rnd = new Random();
		char op = 0;
		
		System.out.println("¡Bienvenido al Juego del Ahorcado!\n");
		
		do {
			
			System.out.println("a) Jugar con palabras en Español");
			System.out.println("b) Jugar con palabras en Inglés");
			System.out.println("c) Salir");
			System.out.println("Elije una opción:");
			op = entrada.next().toLowerCase().charAt(0);
			
			int oportunidades = 0;
			int numLetras = 0;
			int erroresCometidos = 0;
			boolean disponible = false;
			boolean existe = false;
			
			
			switch(op) {
			case 'a' :
				String letrasDisponibles[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m",
						"n","ñ","o","p","q","r","s","t","u","v","w","x","y","z"};
				
				String palabras[] =
				{"UNO", "DOS", "TRES"};
				String palabraAleatoria = palabras[rnd.nextInt(palabras.length)];
				//System.out.println (palabraAleatoria);
				
				oportunidades = palabraAleatoria.length() + (palabraAleatoria.length()/2);
					
				System.out.println("¡Bienvenido al juego del Ahorcado!\r\n" + 
							"Estoy pensando en una palabra de " + palabraAleatoria.length() + " letras.");
				
				System.out.println("-----------------------------------------\n");
				
				char palabraSecreta[] = new char [palabraAleatoria.length()];
				
				for (int i=0; i<palabraSecreta.length; i++) {
					palabraSecreta[i]= '_';
				}//for
				
				do {
					
					System.out.println("Te quedan " + (oportunidades - erroresCometidos) + " oportunidades para adivinar.");
					
					System.out.print("Letras Disponibles: ");
					for (int i=0; i<letrasDisponibles.length; i++) {	
						System.out.print(letrasDisponibles[i]);	
					}//for
					
					System.out.println("\nPor favor ingresa una letra: ");
					String letra = entrada.next().toLowerCase().substring(0,1);
					
					char caracter = letra.charAt(0);
					byte caracteres = (byte)caracter;
					
					if(caracteres == -15 || (caracteres > 96 && caracteres<123)) {
						
					}else {
						System.out.println("Caracter invalido!\n");continue;
					}
					
					for (int i=0; i<letrasDisponibles.length; i++) {
						
						if(letrasDisponibles[i].equals(letra)) {
							disponible = true;
						}//if
					}//for
					
					if (disponible)
					{
						letra = letra.toUpperCase();
						char letra1 = letra.charAt(0);
						
						for (int i=0; i<palabraAleatoria.length(); i++) {
							
							if(letra1 == palabraAleatoria.charAt(i)) {
								palabraSecreta[i] = letra1;
								numLetras++;
								existe = true;		
							}//if2
						}//for
						
						if (existe) {
							System.out.print("Bien hecho: ");
							existe = false;
							}//if3 
						else {
							System.out.println("Oops! Esa letra no está en la palabra secreta: ");
							erroresCometidos++;
							}//else
						
						for (int i=0; i<palabraSecreta.length; i++) {
									System.out.print( palabraSecreta[i] + " ");
							}//for
						
						for (int i=0; i<letrasDisponibles.length; i++) {
							
							if (letrasDisponibles[i].equals(letra.toLowerCase())) {
								letrasDisponibles[i] = "-";
								disponible = false;
							}//if4
						}//for
						
						
					}//if1
					else 
					{
						System.out.println("Oops! Ya habias ingresado esa letra: ");
						
						for (int i=0; i<palabraSecreta.length; i++) {
							System.out.print( palabraSecreta[i] + " ");
						}//for 
					}
					
					System.out.println("\n-----------------------------------------\n");
					
					if(erroresCometidos == oportunidades) {
						System.out.println("Lo siento, te has quedado sin oportunidades para adivinar.\r\n" + 
								"NO HAS ADIVINADO LA PALABRA. "
								+ "\nLa palabra secreta era: " + palabraAleatoria + "\n\n");
						break;
						
					}
					
					if(numLetras == palabraAleatoria.length() ) {
						System.out.println("¡Felicidades, has GANADO!\n\n");
						
						erroresCometidos = oportunidades;
						break;
					}
						
					
				}while (erroresCometidos <= oportunidades);
				
				break;
				
			case 'b':
				String letrasDisponibles1[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m",
						"n","o","p","q","r","s","t","u","v","w","x","y","z"};
				
				String palabras1[] =
				{"FIVE", "SIX"};
				String palabraAleatoria1 = palabras1[rnd.nextInt(palabras1.length)];
				//System.out.println (palabraAleatoria);
			
				oportunidades = palabraAleatoria1.length() + (palabraAleatoria1.length()/2);
				
				System.out.println("¡Welcome to the hangman game!\r\n" + 
						"I´m thinking in a word of " + palabraAleatoria1.length() + " letters.");
			
				System.out.println("-----------------------------------------\n");
			
				char palabraSecreta1[] = new char [palabraAleatoria1.length()];
			
				for (int i=0; i<palabraSecreta1.length; i++) {
				palabraSecreta1[i]= '_';
				}//for
			
				do {
				
					System.out.println("You have " + (oportunidades - erroresCometidos) + " oportunities to guess.");
				
					System.out.print("Avalible letters: ");
					for (int i=0; i<letrasDisponibles1.length; i++) {	
					System.out.print(letrasDisponibles1[i]);	
					}//for
				
					System.out.println("\nPlease enter a letter: ");
					String letra = entrada.next().toLowerCase().substring(0,1);
					
					char caracter = letra.charAt(0);
					byte caracteres = (byte)caracter;
					
					if(caracteres > 96 && caracteres<123) {
						
					}else {
						System.out.println("Invalid entry!\n");continue;
					}
				
					for (int i=0; i<letrasDisponibles1.length; i++) {
					
					if(letrasDisponibles1[i].equals(letra)) {
						disponible = true;
					}//if
					}
				
					if (disponible)
					{
						letra = letra.toUpperCase();
						char letra1 = letra.charAt(0);
					
					for (int i=0; i<palabraAleatoria1.length(); i++) {
						
						if(letra1 == palabraAleatoria1.charAt(i)) {
							palabraSecreta1[i] = letra1;
							numLetras++;
							existe = true;		
						}//if
					}//for
					
					if (existe) {
						System.out.print("Good job: ");
						existe = false;
						} 
					else {
						System.out.println("Oops! that letter isn´t in the secret word: ");
						erroresCometidos++;
						}
					
					for (int i=0; i<palabraSecreta1.length; i++) {
								System.out.print( palabraSecreta1[i] + " ");
						}//for
					
					for (int i=0; i<letrasDisponibles1.length; i++) {
						
						if (letrasDisponibles1[i].equals(letra.toLowerCase())) {
							letrasDisponibles1[i] = "-";
							disponible = false;
						}
					}
					
					
				}
				else 
				{
					System.out.println("Oops! You have already enter this letter: ");
					
					for (int i=0; i<palabraSecreta1.length; i++) {
						System.out.print( palabraSecreta1[i] + " ");
					}//for 
				}
				
				System.out.println("\n-----------------------------------------\n");
				
				if(erroresCometidos == oportunidades) {
					System.out.println("I´m sorry, you don´t have more oportunities to guess.\r\n" + 
							"YOU HAVEN´T GUESS THE WORD. "
							+ "\nThe secret word is: " + palabraAleatoria1 + "\n\n");
					break;
					
				}
				
				if(numLetras == palabraAleatoria1.length() ) {
					System.out.println("¡Congratulations, you WIN!\n\n");
					
					erroresCometidos = oportunidades;
					break;
				}
					
				
			}while (erroresCometidos <= oportunidades);
				
				break;
				
			case 'c':
				System.out.println("Gracias por haber jugado al ahorcado!");
				break;
				
			default:
				System.out.println("Opcion Invalida!\n");
				
			}//switch
			
		}while (op != 'c');
		
	}

}
package desafios;

import java.util.List;

//Dadas dos listas (List<String> y List<Integer>), crea una lista de objetos que combinen ambos elementos mientras haya coincidencia en índices.

public class CombinarStreams
{
	record Persona(String nombre, int edad) {}

	public static void main(String[] args)
	{
		List<String> nombres = List.of(
				    "Alice", "Bob", "Charlie", "Diana", "Eva"  
				);

		List<Integer> edades = List.of(
				 	25, 30, 22                                
				);

	}

}

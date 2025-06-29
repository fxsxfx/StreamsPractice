package intermedio;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PromedioConFiltros
{
	record Persona(String nombre, String ciudad, int edad) {}

	public static void main(String[] args)
	{
		List<Persona> personas = List.of(
		            new Persona("Ana", "Madrid", 25),
		            new Persona("Luis", "Barcelona", 30),
		            new Persona("Marta", "Madrid", 28),
		            new Persona("Carlos", "Valencia", 22),
		            new Persona("Sofía", "Barcelona", 35)
		        );

		Map<String, List<String>> grupos = personas.stream().collect(Collectors.groupingBy(Persona::ciudad, Collectors.mapping(Persona::nombre, Collectors.toList())));

		Double promEdades = personas.stream().collect(Collectors.averagingInt(Persona::edad));

		Optional<Persona> maximo = personas.stream().collect(Collectors.maxBy(Comparator.comparing(Persona::edad)));
		Optional<Persona> minimo = personas.stream().collect(Collectors.minBy(Comparator.comparing(Persona::edad)));

		List<Integer> listaAplanada = personas.stream()
				.map(Persona::edad)
				.collect(Collectors.toList());

		System.out.println("Personas por ciudad" + grupos);
		System.out.println("Promedio de edades: " + promEdades);
		System.out.println("Edad maxima: " + maximo.get().edad);
		System.out.println("Edad minima: " + minimo.get().edad);
		System.out.println("Lista de edades: " + listaAplanada);




	}

}

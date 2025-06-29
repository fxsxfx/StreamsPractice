package avanzado;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConteoPalabras
{

	public static void main(String[] args)
	{
		String texto = """
				    En un lugar de la Mancha, de cuyo nombre no quiero acordarme, 
				    no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero, 
				    adarga antigua, rocín flaco y galgo corredor. Una olla de algo más vaca 
				    que carnero, salpicón las más noches, duelos y quebrantos los sábados...
				    En la Mancha, el sol sale y se pone cada día, pero Don Quijote no olvida 
				    sus sueños. ¡Oh dulce Dulcinea del Toboso! mancha MANCHA Sol SOL.
				    """;
		
		List<String> palabras = Arrays.stream(texto.split(" ")).map(palabra -> palabra.replaceAll("[^a-zA-ZáéíóúÁÉÍÓÚñÑ]", "")).collect(Collectors.toList());
		
		Map<Object, Long> conteoMancha = palabras.stream().collect(Collectors.groupingBy(palabra -> palabra.equalsIgnoreCase("Mancha"), Collectors.counting()));
		
		Map<Object, Long> conteoEn = palabras.stream().collect(Collectors.groupingBy(palabra -> palabra.equalsIgnoreCase("en"), Collectors.counting()));
		
		Long conteoSol = palabras.stream().filter(palabra -> palabra.equalsIgnoreCase("Sol")).count();
		
		System.out.println("Mancha: " + conteoMancha.get(true));
		System.out.println("En: " + conteoEn.get(true));
		System.out.println("Sol: " + conteoSol);

	}

}

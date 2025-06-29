package avanzado;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Divide una lista de números en dos grupos: pares e impares

public class ParticionarDatos
{
	public static void main(String[] args)
	{
		List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

		Map<Boolean, List<Integer>> paresImpares = numeros.stream().collect(Collectors.partitioningBy(numero -> numero%2 == 0));

		System.out.println("Lista de numeros" + numeros);
		System.out.println("Lista de numeros pares" + paresImpares.get(true));
		System.out.println("Lista de numeros impares" + paresImpares.get(false));
	}
}

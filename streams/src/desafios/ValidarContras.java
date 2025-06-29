package desafios;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ValidarContras
{
	public static void main(String[] args)
	{
		List<String> contrasenas = List.of(
				    "A1234567",      // Válida: 8+ chars, mayúscula y número
				    "SecurePass1",   // Válida
				    "weak",          // Inválida: muy corta
				    "SINNUMEROS",    // Inválida: sin números
				    "alllowercase1", // Inválida: sin mayúsculas
				    "12345678",      // Inválida: solo números
				    "A1b2C3d4",      // Válida
				    "@Password123",  // Válida (aunque tiene símbolo, cumple requisitos base)
				    "",              // Inválida: vacía
				    "  A 1 b 2  ",   // Inválida: espacios (depende de tus reglas)
				    "ABCDEFGH1",     // Válida
				    "a1B2c3D4"       // Válida
				);
		
		Predicate<String> longitud = p -> p.length() >= 8;
		Predicate<String> hayNumero = p -> p.matches(".*\\d.*");
		Predicate<String> hayMayus = p -> p.matches(".*[A-Z].*");
		
		Map<Boolean, List<String>> validacion = contrasenas.stream().collect(Collectors.partitioningBy(longitud.and(hayNumero).and(hayMayus)));
		
		System.out.println("Contrasenas validas: " + validacion.get(true));
		System.out.println("Contrasenas invalidas: " + validacion.get(false));
	}
}

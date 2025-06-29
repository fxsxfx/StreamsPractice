package avanzado;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

//Dada una lista de departamentos, donde cada departamento tiene empleados, calcula el salario promedio por departamento.

public class JerarquiaObjetos
{

	record Departamento(String nombre, List<Empleado> empleados) {}
	record Empleado(String nombre, double salario) {}
	
	public static void main(String[] args)
	{
		List<Departamento> departamentos = List.of(
				    new Departamento("Ventas", List.of(
				        new Empleado("Ana López", 2450.80),
				        new Empleado("Carlos Ruiz", 3200.50),
				        new Empleado("Marta Solís", 1890.00)
				    )),
				    new Departamento("TI", List.of(
				        new Empleado("Pablo García", 4100.20),
				        new Empleado("Luisa Fernández", 3950.75),
				        new Empleado("Raj Patel", 3750.60)
				    )),
				    new Departamento("Marketing", List.of(
				        new Empleado("Sofía Kim", 2800.00),
				        new Empleado("David Wong", 3100.00),
				        new Empleado("Elena Morales", 2650.90),
				        new Empleado("Javier López", 2400.50)
				    )),
				    new Departamento("RH", List.of(
				        new Empleado("Claudia Ríos", 2250.30),
				        new Empleado("André Silva", 1980.00)
				    ))
				);
		
		Optional<Empleado> salarioMax = departamentos.stream().flatMap(depto -> depto.empleados.stream()).collect(Collectors.maxBy(Comparator.comparing(Empleado::salario)));
		
		Map<String, Double> promedios = departamentos.stream()
				.flatMap(depto -> depto.empleados().stream()
						.map(emp -> new AbstractMap.SimpleEntry<>(depto.nombre(), emp.salario())))
				.collect(Collectors.groupingBy(Map.Entry::getKey,
						Collectors.averagingDouble(Map.Entry::getValue)
						));
		
		
		
		System.out.println(promedios);
		
		System.out.println("Promedio depto. Ventas: " + promedios.get("Ventas"));
		System.out.println("Promedio depto. TI: " + promedios.get("TI"));
		System.out.println("Promedio depto. Marketing: " + promedios.get("Marketing"));
		System.out.println("Promedio depto. RH: " + promedios.get("RH"));
		
		System.out.println("Salario mas alto: " + salarioMax.get().salario + " Empleado: " + salarioMax.get().nombre);
		

	}


}

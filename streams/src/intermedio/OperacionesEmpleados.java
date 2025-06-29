package intermedio;

import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OperacionesEmpleados
{

	//Filtra y obtén los nombres de empleados con salario superior a 2000.
	//Calcula el salario promedio en cada departamento (Map<String, Double>).
	//Encuentra empleados con más de 2 años de antigüedad (usando LocalDate.now()).
	
	public static void main(String[] args)
	{
		record Empleado(String nombre, String departamento, double salario, LocalDate fechaIngreso) {}
		List<Empleado> empleados = List.of(
		    new Empleado("Ana", "Ventas", 2500.00, LocalDate.of(2020, 5, 15)),
		    new Empleado("Luis", "TI", 3200.50, LocalDate.of(2019, 3, 10)),
		    new Empleado("Marta", "Ventas", 1800.75, LocalDate.of(2021, 11, 20))
		);
		
		
		List<String> salariosSup = empleados.stream().filter(emp -> emp.salario > 2000).collect(Collectors.mapping(Empleado::nombre, Collectors.toList()));
		
		Map<String, Double> promDepto = empleados.stream().collect(Collectors.groupingBy(Empleado::departamento, Collectors.averagingDouble(Empleado::salario)));
		
		List<String> empAntiguo = empleados.stream().filter(p -> ChronoUnit.YEARS.between(p.fechaIngreso, LocalDate.now()) > 2).collect(Collectors.mapping(Empleado::nombre, Collectors.toList()));
		
		System.out.println(salariosSup);
		System.out.println(promDepto);
		System.out.println(empAntiguo);
		
	}

}

package basico;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OperacionesProductos
{

	//Obtén los nombres de productos con stock <= 0
	//Calcula el precio total de todos los productos en la categoría "Tecnología".
	//Convierte todos los nombres de productos a mayúsculas.
	
	public static void main(String[] args)
	{
		record Producto(String nombre, String categoria, double precio, int stock) {}
		List<Producto> productos = List.of(
		    new Producto("Laptop", "Tecnologia", 1200.99, 15),
		    new Producto("Smartphone", "Tecnologia", 800.50, 30),
		    new Producto("Libro", "Educación", 25.99, 100),
		    new Producto("Cafetera", "Hogar", 45.80, 0)
		);
		
		
		List<String> agotados = productos.stream().filter(p -> p.stock == 0).collect(Collectors.mapping(Producto::nombre, Collectors.toList()));
		
		Map<String, Double> suma = productos.stream().collect(Collectors.groupingBy(Producto::categoria, Collectors.summingDouble(Producto::precio)));
		
		List<String> nombresMayus = productos.stream().map(p -> p.nombre.toUpperCase()).toList();
		
		System.out.println(agotados);
		System.out.println(suma.get("Tecnologia"));
		System.out.println(nombresMayus);

	}

}

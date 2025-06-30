package avanzado;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import avanzado.OperacionesVentas.Item;

public class OperacionesVentas
{
	
	//Calcula el monto total (double) de cada pedido.
	//Encuentra el productoId con mayor cantidad total vendida.
	//Filtra pedidos realizados en el último mes (usando LocalDateTime).
	
	record Pedido(String id, List<Item> items, LocalDateTime fecha) {}
	record Item(String productoId, int cantidad, double precioUnitario) {}

	public static void main(String[] args)
	{

		List<Pedido> pedidos = List.of(
		    new Pedido("P001", List.of(
		        new Item("A100", 2, 25.99),
		        new Item("A200", 1, 120.50)
		    ), LocalDateTime.of(2023, 1, 15, 10, 30)),
		    new Pedido("P002", List.of(
		        new Item("A100", 3, 25.99)
		    ), LocalDateTime.of(2023, 2, 20, 14, 15))
		);

		Map<Object, Double> totalPedido = pedidos.stream().flatMap(pedido -> pedido.items.stream()
				.map(item -> new AbstractMap.SimpleEntry<>(pedido.id(), item.precioUnitario())))
				.collect(Collectors.groupingBy(Map.Entry::getKey , Collectors.summingDouble(Map.Entry::getValue)));
		
		Optional<Item> mejorProduct = pedidos.stream().flatMap(pedido -> pedido.items.stream()).collect(Collectors.maxBy(Comparator.comparing(Item::precioUnitario)));
				
		List<Pedido> pedidosRecientes = pedidos.stream().filter(f -> ChronoUnit.MONTHS.between(f.fecha.toLocalDate(), LocalDate.now())<1).toList();
		
		System.out.println(totalPedido);
		System.out.println(mejorProduct.get().productoId);
		System.out.println(pedidosRecientes);
		
		
		
	}

}

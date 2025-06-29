package desafios;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fibonacci
{
	public static void main(String[] args)
	{
		List<Integer> fibonacci = Stream.iterate(new int[] {0, 1}, (par) -> new int[] {par[1], par[0] + par[1]}).limit(20).map(par -> par[0]).collect(Collectors.toList());
		
		System.out.println(fibonacci);
		
		
	}
}

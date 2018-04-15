package grokaem.algoritmy.ch7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DeikstraAlghorithm {
	
	public int shortestPath(Map<String, Map<String, Integer>> graph,
			String start, String finish) {
		Map<String, Integer> costs = graph.entrySet().stream()
				.map(x -> x.getKey())
				.filter(x -> !x.equals(start))
				.collect(Collectors.toMap(
						Function.identity(), 
						i -> graph.get(start).containsKey(i) 
							? graph.get(start).get(i) : Integer.MAX_VALUE
				));
		Map<String, String> parents = graph.entrySet().stream()
				.map(x -> x.getKey())
				.filter(x -> !x.equals(start))
				.collect(Collectors
						.toMap(
								Function.identity(), 
								x -> graph.get(start).containsKey(x) ? start : null 
							));
		Set<String> processed = new HashSet<>();
		processed.add(start);
		
	}
	
	private String lowestNode(Map<String, Integer> costs, Set<String>  processed) {
		int min = Integer.MAX_VALUE;
		
		String result = null;
		
		for (Map.Entry<String, Integer> cost : costs.entrySet()) {
			if (!processed.contains(cost.getKey()) && cost.getValue() < min) {
				result = cost.getKey();
				min = cost.getValue();
			}
		}
		return result;
	}
}

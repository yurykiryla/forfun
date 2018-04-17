package grokaem.algoritmy.ch7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DeikstraAlghorithm {
	
	public int shortestPath(Map<String, Map<String, Integer>> graph,
			String start, String finish) {
		Map<String, Integer> costs = new HashMap<>();
		Map<String, String> parents = new HashMap<>();
		
		for (Map.Entry<String, Map<String, Integer>> node : graph.entrySet()) {
			if (node.getValue() != null) {
				for (Map.Entry<String, Integer> to : node.getValue().entrySet()) {
					if (node.getKey().equals(start)) {
						costs.put(to.getKey(), to.getValue());
						parents.put(to.getKey(), node.getKey());
					} else {
						costs.put(to.getKey(), Integer.MAX_VALUE);
						parents.put(to.getKey(), null);
					}
				}
			}
		}
		
		Set<String> processed = new HashSet<>();
		processed.add(start);
		
		String node = lowestNode(costs, processed);
		while (node != null) {
			int cost = costs.get(node);
			Map<String, Integer> neighbours = graph.get(node);
			if (neighbours != null) {
				for (Map.Entry<String, Integer> neighbour : neighbours.entrySet()) {
					int newCost = cost + neighbour.getValue();
					if (costs.get(neighbour.getKey()) > newCost) {
						costs.put(neighbour.getKey(), newCost);
						parents.put(neighbour.getKey(), node);
					}
				}
			}
			processed.add(node);
			node = lowestNode(costs, processed);
		}
		return costs.get(finish);
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

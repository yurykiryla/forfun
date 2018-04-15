package grokaem.algoritmy.ch6;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import com.google.common.collect.Multimap;

public class BroathFirstSearch {
	public boolean search(Multimap<String, String> graph, String start, String target) {
		
		Queue<String> searchQueue = new LinkedList<>();
		searchQueue.addAll(graph.get(start));
		
		Set<String> processed = new HashSet<>();
		processed.add(start);
		
		while (!searchQueue.isEmpty()) {
			String node = searchQueue.poll();
			if (node != null && !processed.contains(node)) {
				if (node.equals(target)) {
					return true;
				} else {
					processed.add(node);
					searchQueue.addAll(graph.get(node));
				}
			}
		}
		
		return false;
	}
}

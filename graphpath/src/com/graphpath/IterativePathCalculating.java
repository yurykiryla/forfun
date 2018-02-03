package com.graphpath;

import java.util.HashMap;
import java.util.Map;

import com.graphpath.Graph.Entry;

public class IterativePathCalculating {

	public static void main(String[] args) {
		Graph<Integer> graph = new GraphUtil().getDefaultGraph();
		System.out.println(getPath(graph));
	}

	private static int getPath(Graph<Integer> graph) {
		Entry<Integer> root = graph.getRoot();
		Map<Entry<Integer>, Integer> map = new HashMap<>();
		map.put(root, root.getValue());
		boolean hasMoreSteps = root.getChildren() != null;
		while (hasMoreSteps) {
			hasMoreSteps = false;
			Map<Entry<Integer>, Integer> map1 = new HashMap<>();
			for (Map.Entry<Entry<Integer>, Integer> entry : map.entrySet()) {
				if (entry.getKey().getChildren() != null) {
					for (Entry<Integer> child : entry.getKey().getChildren()) {
						if (!map1.containsKey(child) 
								|| entry.getValue() + child.getValue() > map1.get(child)) {
							map1.put(child, entry.getValue() + child.getValue());
							if (child.getChildren() != null) {
								hasMoreSteps = true;
							}
						}
					}
				} else {
					map1.put(entry.getKey(), entry.getValue());
				}
			}
			map = map1;
		}

		int result = 0;
		for (Integer value : map.values()) {
			result = value > result ? value : result;
		}
		return result;
	}
}

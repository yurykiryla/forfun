package com.graphpath;

public class GraphUtil {
	
	public Graph<Integer> getDefaultGraph() {
		Graph<Integer> graph = new Graph<Integer>(3);
		
		Graph.Entry<Integer> node1 = graph.add(2, null);
		Graph.Entry<Integer> node2 = graph.add(1, null);
		
		Graph.Entry<Integer> node3 = graph.add(6, node1);
		Graph.Entry<Integer> node4 = graph.add(4, node1);
		node2.addChild(node4);
		Graph.Entry<Integer> node5 = graph.add(6, node2);
		
		graph.add(1, node3);
		Graph.Entry<Integer> node6 = graph.add(2, node3);
		node4.addChild(node6);
		Graph.Entry<Integer> node7 = graph.add(9, node4);
		node5.addChild(node7);
		graph.add(3, node5);
		
		return graph;
	}

}

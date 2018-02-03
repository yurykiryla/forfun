package com.graphpath;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import com.graphpath.Graph.Entry;

public class RecursivePathCalculating {

	public static void main(String[] args) {
		Graph<Integer> graph = new GraphUtil().getDefaultGraph();
		RecursiveStep rootstep = new RecursiveStep(graph.getRoot());
		ForkJoinPool pool = new ForkJoinPool();
		int result = pool.invoke(rootstep);
		System.out.println(result);
	}
	
	static class RecursiveStep extends RecursiveTask<Integer> {
		private final Graph.Entry<Integer> entry;
		
		public RecursiveStep(Graph.Entry<Integer> entry) {
			this.entry = entry;
		}

		/**
		 * 
		 */
		private static final long serialVersionUID = 8941405652929151659L;

		@Override
		protected Integer compute() {
			int value = entry.getValue();
			int max = 0;
			List<Entry<Integer>> children = entry.getChildren();
			if (children != null) {
				for (Entry<Integer> child : children) {
					int result = new RecursiveStep(child).compute();
					max = result > max ? result : max;
				}
			}
			
			return value + max;
		}
		
	}

}

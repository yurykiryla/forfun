package grokaem.algoritmy.ch7;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeikstraAlghorithmTest {
	
	DeikstraAlghorithm classToTest;

	@BeforeEach
	void setUp() throws Exception {
		classToTest = new DeikstraAlghorithm();
	}

	@Test
	void testShortestPath() {
		Map<String, Map<String, Integer>> graph = new HashMap<>();
		
		String start = "start";
		String finish = "finish";
		
		Map<String, Integer> fromStart = new HashMap<>();
		fromStart.put("A", 6);
		fromStart.put("B", 2);
		graph.put(start, fromStart);
		
		Map<String, Integer> fromA = new HashMap<>();
		fromA.put(finish, 1);
		graph.put("A", fromA);
		
		Map<String, Integer> fromB = new HashMap<>();
		fromB.put("A", 3);
		fromB.put(finish, 5);
		graph.put("B", fromB);
		
		graph.put(finish, null);
		
		int result = classToTest.shortestPath(graph, start, finish);
		assertEquals(6, result);
		
	}

}

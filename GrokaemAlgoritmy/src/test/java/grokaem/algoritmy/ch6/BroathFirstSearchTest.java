package grokaem.algoritmy.ch6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

class BroathFirstSearchTest {
	BroathFirstSearch classUnderTest;

	@BeforeEach
	void setUp() throws Exception {
		classUnderTest = new BroathFirstSearch();
	}

	@Test
	void testSearch() {
		Multimap<String, String> graph = ArrayListMultimap.create();
		graph.putAll("you", List.of("alice", "bob", "claire"));
		graph.putAll("bob", List.of("anuj", "peggy"));
		graph.put("alice", "peggy");
		graph.putAll("claire", List.of("thom", "jonny"));
		graph.put("anuj", null);
		graph.put("peggy", null);
		graph.put("thom", null);
		graph.put("jonny", null);
		
		assertTrue(classUnderTest.search(graph, "you", "thom"));
	}

}

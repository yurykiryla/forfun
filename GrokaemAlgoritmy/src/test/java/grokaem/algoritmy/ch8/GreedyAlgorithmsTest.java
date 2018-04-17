package grokaem.algoritmy.ch8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GreedyAlgorithmsTest {
	
	GreedyAlgorithms classUnderTest;

	@BeforeEach
	void setUp() throws Exception {
		classUnderTest = new GreedyAlgorithms();
	}

	@Test
	void testCalculateStations() {
		Set<String> states = new HashSet<>(Set.of("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));
		
		Map<String, Set<String>> stations = new HashMap<>();
		stations.put("kone", Set.of("id", "nv", "ut"));
		stations.put("ktwo", Set.of("wa", "id", "mt"));
		stations.put("fthree", Set.of("or", "nv", "ca"));
		stations.put("kfour", Set.of("nv", "ut"));
		stations.put("kfive", Set.of("ca", "az"));
		
		Set<String> result = classUnderTest.calculateStations(states, stations);
		assertEquals(4, result.size());
	}

}

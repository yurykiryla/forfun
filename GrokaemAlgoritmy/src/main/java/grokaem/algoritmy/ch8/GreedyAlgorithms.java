package grokaem.algoritmy.ch8;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GreedyAlgorithms {
	
	public Set<String> calculateStations(Set<String> states, Map<String, Set<String>> stations) {
		Set<String> result = new HashSet<>();
		
		while (states.size() > 0) {
			if (stations.size() == 0) {
				throw new RuntimeException("invalid input data");
			}
			Set<String> coveredStates = new HashSet<>();
			String bestMatch = null;
			
			for (Map.Entry<String, Set<String>> station : stations.entrySet()) {
				Set<String> covered = new HashSet<>(states);
				covered.retainAll(station.getValue());
				if (covered.size() > coveredStates.size()) {
					coveredStates = covered;
					bestMatch = station.getKey();
				}
			}
			
			states.removeAll(stations.remove(bestMatch));
			result.add(bestMatch);
		}
		
		return result;
	}

}

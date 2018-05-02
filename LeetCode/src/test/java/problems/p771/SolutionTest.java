package problems.p771;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {
	
	Solution solution;

	@BeforeEach
	void setUp() throws Exception {
		solution = new Solution();
	}

	@Test
	void testNumJewelsInStones() {
		String J = "artyERTYerytyertASDFHGsadfhgjtrsdger";
		String S = "aAAsdfgdfhretuYTUYHFGhdfguASDFGFGbbbb";
		assertEquals(30, solution.numJewelsInStones(J, S));
	}

}

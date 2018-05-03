package problems.p264;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UglyNumberIITest {
	
	private UglyNumberII solution;

	@BeforeEach
	void setUp() throws Exception {
		solution = new UglyNumberII();
	}

	@Test
	void testNthUglyNumber() {
		int actual = solution.nthUglyNumber(10);
		int expected = 12;
		assertEquals(expected, actual);
	}

}

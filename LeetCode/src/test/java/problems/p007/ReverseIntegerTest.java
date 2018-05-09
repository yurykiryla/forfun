package problems.p007;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReverseIntegerTest {
	ReverseInteger solution;

	@BeforeEach
	void setUp() throws Exception {
		solution = new ReverseInteger();
	}

	@Test
	void testReverse() {
		int x = 1534236469;
		int expected = 0;
		int actual = solution.reverse(x);
		assertEquals(expected, actual);
	}

}

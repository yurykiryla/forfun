package problems.p008;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringToInteger_atoiTest {
	StringToInteger_atoi solution;

	@BeforeEach
	void setUp() throws Exception {
		solution = new StringToInteger_atoi();
	}

	@Test
	void testMyAtoi() {
		String str = "2147483648";
		int actual = solution.myAtoi(str);
		int expected = Integer.MAX_VALUE;
		assertEquals(expected, actual);
	}

}

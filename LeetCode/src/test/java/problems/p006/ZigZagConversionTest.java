package problems.p006;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ZigZagConversionTest {
	ZigZagConversion solution;

	@BeforeEach
	void setUp() throws Exception {
		solution = new ZigZagConversion();
	}

	@Test
	void testConvert() {
		String s = "PAYPALISHIRING";
		int numRows = 3;
		String expected = "PAHNAPLSIIGYIR";
		String actual = solution.convert(s, numRows);
		assertEquals(expected, actual);
	}

}

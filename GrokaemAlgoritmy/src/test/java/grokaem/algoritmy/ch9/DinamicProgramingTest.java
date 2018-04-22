package grokaem.algoritmy.ch9;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DinamicProgramingTest {
	DinamicPrograming classunderTest;

	@BeforeEach
	void setUp() throws Exception {
		classunderTest = new DinamicPrograming();
	}

	@Test
	void testFillBag() {
		int size = 4;
		List<Good> goods = List.of(
				new Good("Notebook", 2000, 3), 
				new Good("Guitap", 1500, 1),
				new Good("Magnitofon", 3000, 4),
				new Good("iPhone", 2000, 1)
			);
		assertEquals(4000, classunderTest.fillBag(size, goods));
	}

	@Test
	void testLongestCommonSequence() {
		assertEquals(3, classunderTest.longestCommonSequence("fish", "hish"));
		
		assertEquals(2, classunderTest.longestCommonSequence("fish", "vista"));
		
		assertEquals(2, classunderTest.longestCommonSequence("fort", "fosh"));
	}
	
	@Test
	void testLongestSequence() {
		assertEquals(3, classunderTest.longestSequence("fish", "fosh"));
	}
}

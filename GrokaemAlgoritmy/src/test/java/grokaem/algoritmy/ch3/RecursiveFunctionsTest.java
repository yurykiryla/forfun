package grokaem.algoritmy.ch3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveFunctionsTest {
    private RecursiveFunctions recursiveFunctions;

    @BeforeEach
    void setUp() {
        recursiveFunctions = new RecursiveFunctions();
    }

    @Test
    void factorial() {
        assertEquals(120, recursiveFunctions.factorial(5));
    }
}
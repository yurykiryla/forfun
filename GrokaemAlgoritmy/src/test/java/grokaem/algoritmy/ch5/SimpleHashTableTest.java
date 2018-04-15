package grokaem.algoritmy.ch5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleHashTableTest {
    SimpleHashTable<String> simpleHashTable;

    @BeforeEach
    void setUp() {
        simpleHashTable = new SimpleHashTable<>();
    }

    @Test
    void get() {
        String first = "tersd";
        String second = "sdg";
        simpleHashTable.put(first);
        simpleHashTable.put(second);
        assertEquals(first, simpleHashTable.get(first));
        assertEquals(second, simpleHashTable.get(second));
    }
}
/**
 * 
 */
package com.example.search;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Yury_Kiryla
 *
 */
class LinearSearchTest {
  
  LinearSearch search;

  /**
   * @throws java.lang.Exception
   */
  @BeforeEach
  void setUp() throws Exception {
    search = new LinearSearch();
  }

  /**
   * Test method for {@link com.example.search.LinearSearch#searchIndex(int[], int)}.
   */
  @Test
  void testSearchIndex() {
    int[] array  = {1, 2, 32, -3, 11, 98};
    
    assertEquals(-1, search.searchIndex(array, 43));
    assertEquals(2, search.searchIndex(array, 32));
  }

}

/**
 * 
 */
package com.example.sort;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Yury_Kiryla
 *
 */
class BucketSortTest {
  
  private BucketSort solution;

  /**
   * @throws java.lang.Exception
   */
  @BeforeEach
  void setUp() throws Exception {
    solution = new BucketSort();
  }

  /**
   * Test method for {@link com.example.sort.BucketSort#sort(int[])}.
   */
  @Test
  void testSort() {
    int[] array = {23, 21, 20, 43, 54, 65, 42, 43, 55};
    solution.sort(array);
    for (int i = 1; i < array.length; i++) {
      assertTrue(array[i - 1] <= array[i]);
    }
  }

}

/**
 * 
 */
package com.example.search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Yury_Kiryla
 *
 */
class BinarySearchTest {

  BinarySearch search;

  /**
   * @throws java.lang.Exception
   */
  @BeforeEach
  void setUp() throws Exception {
    search = new BinarySearch();
  }

  /**
   * Test method for {@link com.example.search.BinarySearch#iterativeSearch(int[], int)}.
   */
  @Test
  void testIterativeSearch() {
    int[] array = {-43, -11, -1, 0, 2, 5, 9};
    assertEquals(2, search.iterativeSearch(array, -1));
  }

  /**
   * Test method for {@link com.example.search.BinarySearch#iterativeSearch(int[], int)}.
   */
  @Test
  void testIterativeSearch_NotSorted() {
    int[] array = {-43, -11, -1, 0, 2, 5, 9, 0};
    assertThrows(AssertionError.class, () -> search.iterativeSearch(array, 0));
  }

  /**
   * Test method for {@link com.example.search.BinarySearch#iterativeSearch(int[], int)}.
   */
  @Test
  void testIterativeSearch_NotFound() {
    int[] array = {-43, -11, -1, 0, 2, 5, 9};
    assertEquals(-1, search.iterativeSearch(array, 1));
  }
  
  /**
   * Test method for {@link com.example.search.BinarySearch#recursiveSearch(int[], int)}.
   */
  @Test
  void testRecursiveSearch() {
    int[] array = {-43, -11, -1, 0, 2, 5, 9};
    assertEquals(2, search.recursiveSearch(array, -1));
  }

  /**
   * Test method for {@link com.example.search.BinarySearch#recursiveSearch(int[], int)}.
   */
  @Test
  void testRecursiveSearch_NotSorted() {
    int[] array = {-43, -11, -1, 0, 2, 5, 9, 0};
    assertThrows(AssertionError.class, () -> search.recursiveSearch(array, 0));
  }

  /**
   * Test method for {@link com.example.search.BinarySearch#recursiveSearch(int[], int)}.
   */
  @Test
  void testRecursiveSearch_NotFound() {
    int[] array = {-43, -11, -1, 0, 2, 5, 9};
    assertEquals(-1, search.recursiveSearch(array, 1));
  }
}

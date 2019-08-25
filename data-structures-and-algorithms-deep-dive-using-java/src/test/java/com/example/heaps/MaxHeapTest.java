package com.example.heaps;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

class MaxHeapTest {

  MaxHeap maxHeap;

  @Test
  void testMaxHeap() {
    try {
      maxHeap = new MaxHeap(5);
    } catch (Throwable e) {
      fail("Constructor failure", e);
    }
  }

  @Test
  void testIsFull() {
    maxHeap = new MaxHeap(2);
    assertFalse(maxHeap.isFull());
    maxHeap.insert(2);
    maxHeap.insert(1);
    assertTrue(maxHeap.isFull());
  }

  @Test
  void testInsert() {
    maxHeap = new MaxHeap(2);
    maxHeap.insert(3);
    assertFalse(maxHeap.isFull());
    maxHeap.insert(5);
    assertTrue(maxHeap.isFull());
    assertThrows(IndexOutOfBoundsException.class, () -> maxHeap.insert(2));
  }

  @Test
  void testDelete() {
    maxHeap = new MaxHeap(10);

    maxHeap.insert(16);
    maxHeap.insert(22);
    maxHeap.insert(20);
    maxHeap.insert(11);
    maxHeap.insert(15);
    maxHeap.insert(1);
    maxHeap.insert(6);
    maxHeap.insert(8);

    assertEquals(16, maxHeap.delete(1));

    int[] expected = {22, 15, 20, 11, 8, 1, 6};
    int[] actual = maxHeap.getHeap();

    assertArrayEquals(expected, actual);
  }

  @Test
  void testPeek() {
    maxHeap = new MaxHeap(10);
    
    assertThrows(IndexOutOfBoundsException.class, () -> maxHeap.peek());

    maxHeap.insert(16);
    maxHeap.insert(22);
    maxHeap.insert(20);
    maxHeap.insert(11);
    maxHeap.insert(15);
    maxHeap.insert(1);
    maxHeap.insert(6);
    maxHeap.insert(8);
    
    assertEquals(22, maxHeap.peek());
  }
  
  @Test
  void testSort() {
    maxHeap = new MaxHeap(10);

    maxHeap.insert(16);
    maxHeap.insert(22);
    maxHeap.insert(20);
    maxHeap.insert(11);
    maxHeap.insert(15);
    maxHeap.insert(1);
    maxHeap.insert(6);
    maxHeap.insert(8);

    maxHeap.sort();

    int[] expected = {1, 6, 8, 11, 15, 16, 20, 22};
    int[] actual = maxHeap.getHeap();

    assertArrayEquals(expected, actual);
  }
}

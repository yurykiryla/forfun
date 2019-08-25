package com.example.heaps;

import java.util.Arrays;

public class MaxHeap {

  private int[] heap;

  private int size;

  public MaxHeap(int capacity) {
    heap = new int[capacity];
  }

  public boolean isFull() {
    return size == heap.length;
  }

  public void insert(int value) {
    if (isFull()) {
      throw new IndexOutOfBoundsException("Heap is full");
    }
    heap[size] = value;
    fixHeapAbove(size);
    size++;
  }

  public int delete(int index) {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException("Heap is empty");
    }

    int parentIndex = getParentIndex(index);
    int deletedValue = heap[index];

    heap[index] = heap[size - 1];

    if (index == 0 || heap[index] < heap[parentIndex]) {
      fixHeapBellow(index, size - 1);
    } else {
      fixHeapAbove(index);
    }

    size--;

    return deletedValue;

  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int[] getHeap() {
    return Arrays.copyOf(heap, size);
  }
  
  public int peek() {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException("Heap is empty");
    }
    return heap[0];
  }
  
  public void sort() {
    int lastHeapIndex = size - 1;
    for (int i = 0; i < lastHeapIndex; i++) {
      int tmp = heap[0];
      heap[0] = heap[lastHeapIndex - i];
      heap[lastHeapIndex - i] = tmp;
      
      fixHeapBellow(0, lastHeapIndex - i - 1);
    }
  }

  private int getParentIndex(int index) {
    return (index - 1) / 2;
  }

  private void fixHeapAbove(int index) {
    int newValue = heap[index];
    while (index > 0 && newValue > heap[getParentIndex(index)]) {
      heap[index] = heap[getParentIndex(index)];
      index = getParentIndex(index);
    }
    heap[index] = newValue;
  }

  private void fixHeapBellow(int index, int lastHeapIndex) {
    int childToSwapIndex;

    while (index <= lastHeapIndex) {
      int leftChildIndex = getChildIndex(index, true);
      int rightClildIndex = getChildIndex(index, false);

      if (leftChildIndex <= lastHeapIndex) {
        if (rightClildIndex > lastHeapIndex) {
          childToSwapIndex = leftChildIndex;
        } else {
          childToSwapIndex =
              (heap[leftChildIndex] > heap[rightClildIndex] ? leftChildIndex : rightClildIndex);
        }


        if (heap[index] < heap[childToSwapIndex]) {
          int tmp = heap[index];
          heap[index] = heap[childToSwapIndex];
          heap[childToSwapIndex] = tmp;
        } else {
          break;
        }

        index = childToSwapIndex;
      } else {
        break;
      }
    }
  }

  private int getChildIndex(int index, boolean left) {
    return 2 * index + (left ? 1 : 2);
  }
}

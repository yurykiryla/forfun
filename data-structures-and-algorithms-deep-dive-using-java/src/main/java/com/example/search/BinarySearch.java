package com.example.search;

public class BinarySearch {

  public int iterativeSearch(int[] input, int value) {

    for (int i = 1; i < input.length; i++) {
      assert (input[i - 1] <= input[i]);
    }

    int start = 0;
    int end = input.length;

    while (start < end) {
      int midpoint = (start + end) / 2;
      if (input[midpoint] == value) {
        return midpoint;
      }
      if (input[midpoint] < value) {
        start = midpoint + 1;
      } else {
        end = midpoint;
      }
    }

    return -1;
  }

  public int recursiveSearch(int[] input, int value) {

    for (int i = 1; i < input.length; i++) {
      assert (input[i - 1] <= input[i]);
    }
    
    return recursiveSearch(input, 0, input.length, value);
  }
  
  private int recursiveSearch(int[] input, int start, int end, int value) {
    if (start >= end) {
      return -1;
    }
    
    int midpoint = (start + end) / 2;
    if (input[midpoint] == value) {
      return midpoint;
    }
    if (input[midpoint] < value) {
      return recursiveSearch(input, midpoint + 1, end, value);
    } else {
      return recursiveSearch(input, start, midpoint, value);
    }
  }
}

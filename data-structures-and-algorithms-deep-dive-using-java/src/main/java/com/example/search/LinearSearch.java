package com.example.search;

public class LinearSearch {

  public int searchIndex(int[] input, int value) {
    for (int i = 0; i < input.length; i++) {
      if (input[i] == value) {
        return i;
      }
    }
    return -1;
  }

}

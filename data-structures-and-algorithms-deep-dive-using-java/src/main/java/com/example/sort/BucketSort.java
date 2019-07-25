/**
 * 
 */
package com.example.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Yury_Kiryla
 *
 */
public class BucketSort {
  
  @SuppressWarnings({"unchecked", "rawtypes"})
  public void sort(int[] input) {
    List<Integer>[] buckets = new List[10];
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new ArrayList<Integer>();
    }

    for (int value : input) {
      buckets[hash(value)].add(value);
    }

    for (List bucket : buckets) {
      Collections.sort(bucket);
    }

    int j = 0;
    for (int i = 0; i < buckets.length; i++) {
      for (int value : buckets[i]) {
        input[j++] = value;
      }
    }
  }

  private int hash(int value) {
    return value / (int) 10;
  }
}

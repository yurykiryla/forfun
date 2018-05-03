package problems.p84;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 * 
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * @author Yury_Kiryla
 *
 */
public class LargestRectangleInHistogram {
	
	public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        int maxHeight = IntStream.of(heights).max().getAsInt();
        if (maxHeight <= 0) {
            return 0;
        }
        int result = maxHeight;
        for (int i = 1; i <= maxHeight; i++) {
            int number = 0;
            for(int j = 0; j < heights.length; j++) {
                if (heights[j] >= i) {
                    number++;
                } else {
                    number = 0;
                }
                int area = i * number;
                if (area > result) {
                    result = area;
                }
            }
        }
        return result;
    }
	
	public int largestRectangleAreaWithSet(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        int result = 0;
        
        Set<Integer> heightsSet = new HashSet<>();
        for (int height : heights) {
            heightsSet.add(height);
        }
        
        for (int height : heightsSet) {
            int number = 0;
            for(int j = 0; j < heights.length; j++) {
                if (heights[j] >= height) {
                    number++;
                } else {
                    number = 0;
                }
                int area = height * number;
                if (area > result) {
                    result = area;
                }
            }
        }
        return result;
    }
}

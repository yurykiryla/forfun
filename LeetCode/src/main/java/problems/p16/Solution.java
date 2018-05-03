package problems.p16;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/3sum-closest/description/
 * 
 * Given an array nums of n integers and an integer target, find three integers in nums such that 
 * the sum is closest to target. Return the sum of the three integers. You may assume that each 
 * input would have exactly one solution.
 * 
 * @author Yury_Kiryla
 *
 */
public class Solution {
	public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if (nums.length <= 3) {
        	return IntStream.of(nums).sum();
        }
        Arrays.sort(nums);
        
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1; 
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) {
                	return sum;
                }
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }

}
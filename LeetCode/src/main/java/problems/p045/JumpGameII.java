/**
 * 
 */
package problems.p045;

/**
 * https://leetcode.com/problems/jump-game-ii/description/
 * 
 * Given an array of non-negative integers, you are initially positioned at the first 
 * index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * Example:
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * 
 * Note:
 * You can assume that you can always reach the last index.
 * 
 * @author Катя
 *
 */
public class JumpGameII {
	public int jump(int[] nums) {
        if (nums == null || nums.length <= 1 || nums[0] == 0) {
            return 0;
        }
        if (nums[0] >= nums.length - 1) {
            return 1;
        }
        
        int[] jumps = new int[nums.length];
        
        for (int i = 1; i <= nums[0]; i++) {
            jumps[i] = 1;
        }
        int longest = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (i + nums[i] >= nums.length - 1) {
                return jumps[i] + 1;
            }
            for (int j = longest + 1; j <= i + nums[i]; j++) {
                jumps[j] = jumps[i] + 1;
                longest = j;
            }
        }
        
        return 0;
    }
}

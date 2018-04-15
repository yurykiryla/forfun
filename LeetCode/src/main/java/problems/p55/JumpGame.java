package problems.p55;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * For example:
 * A = [2,3,1,1,4], return true.
 *
 * A = [3,2,1,0,4], return false.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null)
            return false;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > max)
                return false;
            if (i + nums[i] > max)
                max = i + nums[i];
            if (max >= nums.length - 1)
                return true;
        }
        return true;
    }
}

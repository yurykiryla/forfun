package problems.p404;

import java.util.Stack;

/**
 * https://leetcode.com/problems/sum-of-left-leaves/description/
 * 
 * Find the sum of all left leaves in a given binary tree.
 * 
 * @author Yury_Kiryla
 *
 */
public class Solution {
	
	public int sumOfLeftLeaves(TreeNode root) {
        int amount = 0;
        if (root != null) {
            if (root.left != null && root.left.left == null && root.left.right == null) {
                amount += root.left.val;
            }
            amount += sumOfLeftLeaves(root.left);
            amount += sumOfLeftLeaves(root.right);
        }
        return amount;
    }

	public int sumOfLeftLeavesItertive(TreeNode root) {
		if(root == null) return 0;
	    int ans = 0;
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    stack.push(root);
	    
	    while(!stack.empty()) {
	        TreeNode node = stack.pop();
	        if(node.left != null) {
	            if (node.left.left == null && node.left.right == null)
	                ans += node.left.val;
	            else
	                stack.push(node.left);
	        }
	        if(node.right != null) {
	            if (node.right.left != null || node.right.right != null)
	                stack.push(node.right);
	        }
	    }
	    return ans;
    }
}

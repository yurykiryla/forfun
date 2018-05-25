/**
 * 
 */
package problems.p102;

import java.util.ArrayList;
import java.util.List;

import problems.p404.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 
 * return its level order traversal as:
 * 
 * [
 *  [3],
 *  [9,20],
 *  [15,7]
 * ]
 * 
 * @author Катя
 *
 */
public class BinaryTreeLevelOrderTraversal {
public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        List<TreeNode> level = new ArrayList<>();
        
        if (root != null) {
            level.add(root);
        }
        
        while (!level.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList<>();
            List<Integer> levelResult = new ArrayList<>();
            result.add(levelResult);
            for (TreeNode node : level) {
                levelResult.add(node.val);
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            level = nextLevel;
        }
        
        return result;
    }
}

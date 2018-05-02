package problems.p404;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {
	
	Solution solution;

	@BeforeEach
	void setUp() throws Exception {
		solution = new Solution();
	}

	@Test
	void testSumOfLeftLeaves() {
		assertEquals(24, solution.sumOfLeftLeaves(buildTree()));
	}

	@Test
	void testSumOfLeftLeavesItertive() {
		assertEquals(24, solution.sumOfLeftLeavesItertive(buildTree()));
	}

	private TreeNode buildTree() {
		TreeNode seven = new TreeNode(7);
		TreeNode fifteen = new TreeNode(15);
		
		TreeNode twenty = new TreeNode(20);
		twenty.right = seven;
		twenty.left = fifteen;
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = twenty;
		
		return root;
	}
}

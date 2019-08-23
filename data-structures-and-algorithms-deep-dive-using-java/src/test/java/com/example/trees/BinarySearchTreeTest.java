/**
 * 
 */
package com.example.trees;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Yury_Kiryla
 *
 */
class BinarySearchTreeTest {
  
  BinarySearchTree tree;

  /**
   * @throws java.lang.Exception
   */
  @BeforeEach
  void setUp() throws Exception {
    tree = new BinarySearchTree();
  }

  /**
   * Test method for {@link com.example.trees.BinarySearchTree#insert(int)}.
   */
  @Test
  void testInsert() {
    try {
      tree.insert(25);
      tree.insert(22);
      tree.insert(22);
      tree.insert(24);
      tree.insert(10);
      tree.insert(34);
      tree.insert(8);
      tree.insert(26);
      tree.insert(30);
      tree.insert(36);
    } catch (Exception e) {
      fail();
    }
  }

  /**
   * Test method for {@link com.example.trees.BinarySearchTree#traverseInOrder()}.
   */
  @Test
  void testTraverseInOrder() {
    tree.insert(25);
    tree.insert(22);
    tree.insert(22);
    tree.insert(24);
    tree.insert(10);
    tree.insert(34);
    tree.insert(8);
    tree.insert(26);
    tree.insert(30);
    tree.insert(36);
    
    int[] expected = {8, 10, 22, 24, 25, 26, 30, 34, 36};
    assertArrayEquals(expected, tree.traverseInOrder());
  }

  @Test
  void testGet() {
    tree.insert(25);
    tree.insert(22);
    tree.insert(22);
    tree.insert(24);
    tree.insert(10);
    tree.insert(34);
    tree.insert(8);
    tree.insert(26);
    tree.insert(30);
    tree.insert(36);
    
    assertEquals(30, tree.get(30).intValue());
    assertNull(tree.get(7));
  }
  
  @Test
  void testMin() {
    tree.insert(25);
    tree.insert(22);
    tree.insert(22);
    tree.insert(24);
    tree.insert(10);
    tree.insert(34);
    tree.insert(8);
    tree.insert(26);
    tree.insert(30);
    tree.insert(36);
    
    assertEquals(8, tree.min());
  }
  
  @Test
  void testMax() {
    tree.insert(25);
    tree.insert(22);
    tree.insert(22);
    tree.insert(24);
    tree.insert(10);
    tree.insert(34);
    tree.insert(8);
    tree.insert(26);
    tree.insert(30);
    tree.insert(36);
    
    assertEquals(36, tree.max());
  }
  
  @Test
  void testDeleteLeaf() {
    tree.insert(25);
    tree.insert(22);
    tree.insert(22);
    tree.insert(24);
    tree.insert(10);
    tree.insert(34);
    tree.insert(8);
    tree.insert(26);
    tree.insert(30);
    tree.insert(36);
    
    tree.delete(30);
    
    int[] expected = {8, 10, 22, 24, 25, 26, 34, 36};
    assertArrayEquals(expected, tree.traverseInOrder());
  }
  
  @Test
  void testDeleteSingleChildNode() {
    tree.insert(25);
    tree.insert(22);
    tree.insert(22);
    tree.insert(24);
    tree.insert(10);
    tree.insert(34);
    tree.insert(8);
    tree.insert(26);
    tree.insert(30);
    tree.insert(36);
    
    tree.delete(26);
    
    int[] expected = {8, 10, 22, 24, 25, 30, 34, 36};
    assertArrayEquals(expected, tree.traverseInOrder());
  }
  
  @Test
  void testDeleteTwoChildrenNode() {
    tree.insert(25);
    tree.insert(22);
    tree.insert(22);
    tree.insert(24);
    tree.insert(10);
    tree.insert(34);
    tree.insert(8);
    tree.insert(26);
    tree.insert(30);
    tree.insert(36);
    
    tree.delete(34);
    
    int[] expected = {8, 10, 22, 24, 25, 26, 30, 36};
    assertArrayEquals(expected, tree.traverseInOrder());
  }
  
  @Test
  void testDeleteRootNode() {
    tree.insert(25);
    tree.insert(22);
    tree.insert(22);
    tree.insert(24);
    tree.insert(10);
    tree.insert(34);
    tree.insert(8);
    tree.insert(26);
    tree.insert(30);
    tree.insert(36);
    
    tree.delete(25);
    
    int[] expected = {8, 10, 22, 24, 26, 30, 34, 36};
    assertArrayEquals(expected, tree.traverseInOrder());
  }
  
  @Test
  void testTraversePreOrder() {
    tree.insert(25);
    tree.insert(22);
    tree.insert(22);
    tree.insert(24);
    tree.insert(10);
    tree.insert(34);
    tree.insert(8);
    tree.insert(26);
    tree.insert(30);
    tree.insert(36);
    
    int[] expected = {25, 22, 10, 8, 24, 34, 26, 30, 36};
    assertArrayEquals(expected, tree.traversePreOrder());
  }
}

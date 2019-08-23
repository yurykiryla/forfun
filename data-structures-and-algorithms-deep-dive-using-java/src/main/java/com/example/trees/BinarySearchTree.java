/**
 * 
 */
package com.example.trees;

import java.util.NoSuchElementException;

/**
 * @author Yury_Kiryla
 *
 */
public class BinarySearchTree {

  private TreeNode root;

  public void insert(int value) {
    if (root == null) {
      root = new TreeNode(value);
    } else {
      root.insert(value);
    }
  }

  public int[] traverseInOrder() {
    if (root == null) {
      return null;
    } else {
      return root.traverseInOrder();
    }
  }
  
  public Integer get(int value) {
    if (root == null) {
      return null;
    }
    TreeNode result = root.get(value);
    if (result == null) {
      return null;
    }
    return result.data;
  }
  
  public int min() {
    if (root == null) {
      throw new NoSuchElementException();
    }
    return root.min();
  }
  
  public int max() {
    if (root == null) {
      throw new NoSuchElementException();
    }
    return root.max();
  }
  
  public void delete(int value) {
    root = delete(root, value);
  }
  
  public int[] traversePreOrder() {
    if (root == null) {
      return null;
    } else {
      return root.traversePreOrder();
    }
  }

  private TreeNode delete(TreeNode subtreeRoot, int value) {
    if (subtreeRoot == null) {
      return subtreeRoot;
    }
    
    if (value < subtreeRoot.data) {
      subtreeRoot.leftChild = delete(subtreeRoot.leftChild, value);
    } else if (value > subtreeRoot.data) {
      subtreeRoot.rightChild = delete(subtreeRoot.rightChild, value);
    } else {
      // Cases 1 and 2 - node to delete has 0 or 1 child
      if (subtreeRoot.leftChild == null) {
        return subtreeRoot.rightChild;
      } else if (subtreeRoot.rightChild == null) {
        return subtreeRoot.leftChild;
      }
      
      // Case 3 - node to delete has 2 children
      
      // Replace the value in the subtreeRoot with the smallest value
      // from the right subtree
      subtreeRoot.data = subtreeRoot.rightChild.min();
      
      // Delete the node that has the smallest value in the right subtree
      subtreeRoot.rightChild = delete(subtreeRoot.rightChild, subtreeRoot.data);
    }
    
    return subtreeRoot;
  }
  
  private static class TreeNode {
    int data;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int data) {
      super();
      this.data = data;
    }

    int[] traverseInOrder() {
      int[] left = {};
      int[] right = {};
      if (leftChild != null) {
        left = leftChild.traverseInOrder();
      }
      if (rightChild != null) {
        right = rightChild.traverseInOrder();
      }
      int[] result = new int[left.length + right.length + 1];
      System.arraycopy(left, 0, result, 0, left.length);
      result[left.length] = data;
      System.arraycopy(right, 0, result, left.length + 1, right.length);
      return result;
    }

    void insert(int value) {
      if (data == value) {
        return;
      }
      if (value < data) {
        if (leftChild == null) {
          leftChild = new TreeNode(value);
        } else {
          leftChild.insert(value);
        }
      } else {
        if (rightChild == null) {
          rightChild = new TreeNode(value);
        } else {
          rightChild.insert(value);
        }
      }
    }
    
    TreeNode get(int value) {
      if (value == data) {
        return this;
      }
      if (value < data) {
        if (leftChild != null) {
          return leftChild.get(value);
        }
      } else {
        if (rightChild != null) {
          return rightChild.get(value);
        }
      }
      return null;
    }
    
    int min() {
      if (leftChild == null) {
        return data;
      } else {
        return leftChild.min();
      }
    }
    
    int max() {
      if (rightChild == null) {
        return data;
      } else {
        return rightChild.max();
      }
    }
    
    int[] traversePreOrder() {
      int[] left = {};
      int[] right = {};
      if (leftChild != null) {
        left = leftChild.traversePreOrder();
      }
      if (rightChild != null) {
        right = rightChild.traversePreOrder();
      }
      int[] result = new int[left.length + right.length + 1];
      result[0] = data;
      System.arraycopy(left, 0, result, 1, left.length);
      System.arraycopy(right, 0, result, left.length + 1, right.length);
      return result;
    }
  }
}

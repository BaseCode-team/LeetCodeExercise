package base.entity;

import lombok.Data;

/**
 * 二叉树
 */
@Data
public class TreeNode {
     private int val;
     private TreeNode parent;
     private TreeNode left;
     private TreeNode right;
     public TreeNode() {}
     public TreeNode(int val) { this.val = val; }
     public TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

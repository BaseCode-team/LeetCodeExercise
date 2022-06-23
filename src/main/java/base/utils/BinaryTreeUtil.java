package base.utils;

import base.entity.TreeNode;

/**
 * 二叉树工具类
 */
public class BinaryTreeUtil {
    public static TreeNode arrayToBinaryTree(Integer[] list){
        if(list.length == 0){
            throw new RuntimeException("数组长度为0，没有元素用来建树！！！");
        }
        //把第一个元素变成根结点
        int first = list[0];
        TreeNode root = new TreeNode(first);
        //TODO 将数组转换成二叉树
        return root;
    }
}

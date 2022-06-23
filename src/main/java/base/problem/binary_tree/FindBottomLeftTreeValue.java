package base.problem.binary_tree;

import base.entity.TreeNode;
import base.program.Topic;
import lombok.Data;

/**
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 * 输入: root = [2,1,3]
 * 输出: 1
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 */
@Data
public abstract class FindBottomLeftTreeValue extends Topic<TreeNode> {
    //构造函数初始化输入
    public FindBottomLeftTreeValue(TreeNode treeNode){
        this.setInput(treeNode);
    }
}

package solution;

import base.entity.TreeNode;
import base.problem.binary_tree.FindBottomLeftTreeValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import solution.person1.binary_tree.FindBottomLeftTreeValueByChen;

class FindBottomLeftTreeValueTest {

    @Test
    void runPerson1() {
        TreeNode treeNode = new TreeNode();
        FindBottomLeftTreeValueByChen chenjiahao = new FindBottomLeftTreeValueByChen(treeNode);
        chenjiahao.run(1);
    }
    @Test
    void runPerson2() {
        TreeNode treeNode = new TreeNode();
        FindBottomLeftTreeValueByChen chenjiahao = new FindBottomLeftTreeValueByChen(treeNode);
        chenjiahao.run(1);
    }
    @Test
    void runPerson3() {
        TreeNode treeNode = new TreeNode();
        FindBottomLeftTreeValueByChen chenjiahao = new FindBottomLeftTreeValueByChen(treeNode);
        chenjiahao.run(1);
    }
}
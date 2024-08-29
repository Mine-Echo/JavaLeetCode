// 二叉树的层平均值

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode637 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<Double> ret = new LinkedList<>();
        if (root == null)
            return ret;
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.remove();
                if (node.left != null)
                    deque.add(node.left);
                if (node.right != null)
                    deque.add(node.right);
                sum += node.val;
            }
            ret.add(sum / size);
        }
        return ret;
    }
}

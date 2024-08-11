// 对称二叉树

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode101 {

    public class TreeNode {
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

    public boolean isSymmetric(TreeNode root) {
        // 递归
        // if (root == null)
        //     return true;
        // return isSymmetricCore(root.left, root.right);
        
        // 迭代法，借助队列层序遍历
        if (root == null)
            return true;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(root.left);
        q2.offer(root.right);
        while (q1.size() > 0 && q2.size() > 0) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            if (node1 == null && node2 == null)
                continue;
            if (node1 == null || node2 == null || node1.val != node2.val)
                return false;
            q1.offer(node1.left);
            q1.offer(node1.right);
            q2.offer(node2.right);
            q2.offer(node2.left);
        }
        return true;
    }

    // private boolean isSymmetricCore(TreeNode left, TreeNode right) {
    //     if (left != null && right != null) {
    //         return left.val == right.val && isSymmetricCore(left.left, right.right)
    //                 && isSymmetricCore(left.right, right.left);
    //     } else {
    //         return left == null && right == null ? true : false;
    //     }
    // }
}

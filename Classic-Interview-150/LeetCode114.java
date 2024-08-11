
//二叉树展开为链表
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode114 {

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

    Queue<TreeNode> q = new LinkedList<>();

    public void flatten(TreeNode root) {
        // 前序遍历法
        preOrder(root);
        TreeNode last = new TreeNode();
        TreeNode node = null;
        while (!q.isEmpty()) {
            node = q.poll();
            node.left = null;
            last.right = node;
            last = node;
        }

        // 原地算法：找到左子树的最后一个节点，把右子树拼接到该节点上，然后把左子树移到right
        // TreeNode node = root;
        // TreeNode last;  //last记录左子树的最后说个节点
        // while (node != null) {
        //     last = node.left;
        //     if (last == null){
        //         node=node.right;
        //         continue;
        //     }
        //     while (last.left != null || last.right != null) {
        //         last = last.right != null ? last.right : last.left;
        //     }
        //     last.right = node.right;
        //     node.right = node.left;
        //     node.left = null;
        //     node = node.right;
        // }
    }

    private void preOrder(TreeNode node) {
        if (node == null)
            return;
        q.offer(node);
        preOrder(node.left);
        preOrder(node.right);
    }
}

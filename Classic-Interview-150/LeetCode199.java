// 二叉树的右视图

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode199 {
    public List<Integer> rightSideView(TreeNode root) {
        // 层序遍历，记录每一层最右的节点
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> ret = new LinkedList<>();
        if (root == null)
            return ret;
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.remove();
                if (node.left != null)
                    deque.add(node.left);
                if (node.right != null)
                    deque.add(node.right);
                if (i == size - 1)
                    ret.add(node.val);
            }
        }
        return ret;
    }
}

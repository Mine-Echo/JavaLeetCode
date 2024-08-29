
// 二叉树的锯齿形层次遍历
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (flag) {
                    level.offerLast(node.val);
                } else {
                    level.offerFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }
            flag = !flag;
            result.add(new LinkedList<Integer>(level));
        }
        return result;
    }
}

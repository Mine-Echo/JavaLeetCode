//填充每个节点的下一个右侧节点指针

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode117 {
    public Node connect(Node root) {
        // 利用队列进行层序遍历，并且用head指针标记每一行的头节点
        // 其实用层序遍历不需要用head标记头节点，官解中每次遍历q.size()个元素
        // 这样自然就是一层一层遍历，我太菜了没想到啊
        if (root == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        Node node, head = root, last = new Node();
        while (!q.isEmpty()) {
            node = q.poll();
            if (head == node) {
                last.next = null;
                head = null;
            } else {
                last.next = node;
            }
            last = node;
            if (head == null) {
                head = node.left != null ? node.left : node.right;
            }
            if (node.left != null)
                q.offer(node.left);
            if (node.right != null)
                q.offer(node.right);
        }
        last.next = null;
        return root;

        // 还有一种不借助队列的解法，就是先连接next指针，然后通过next指针遍历并连接下一层
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}

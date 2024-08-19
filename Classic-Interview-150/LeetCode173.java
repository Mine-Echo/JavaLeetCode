import java.util.Deque;
import java.util.LinkedList;

public class LeetCode173 {
    // 方法一：直接中序遍历把顺序存在一个链表中
    // 方法二：借助栈，在使用next时进行一步遍历

    class BSTIterator {

        private IteratorNode now = new IteratorNode();

        public BSTIterator(TreeNode root) {
            inOrder(root, now);
        }

        public int next() {
            now = now.next;
            return now.val;
        }

        public boolean hasNext() {
            return now.next != null;
        }

        class IteratorNode {
            int val;
            IteratorNode next;

            public IteratorNode() {
            };

            public IteratorNode(int val, IteratorNode next) {
                this.val = val;
                this.next = next;
            }

            public IteratorNode(int val) {
                this(val, null);
            }

        }

        private IteratorNode inOrder(TreeNode treeNode, IteratorNode iNode) {
            if (treeNode == null)
                return iNode;
            iNode = inOrder(treeNode.left, iNode);
            iNode.next = new IteratorNode(treeNode.val);
            return inOrder(treeNode.right, iNode.next);
        }
    }

    public static class TreeNode {
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

    // class BSTIterator {

    //     private Deque<TreeNode> stack = new LinkedList<>();

    //     private TreeNode cur;

    //     public BSTIterator(TreeNode root) {
    //         this.cur = root;
    //     }

    //     public int next() {
    //         while (cur != null) {
    //             stack.addFirst(cur);
    //             cur = cur.left;
    //         }
    //         cur = stack.removeFirst();
    //         int ret = cur.val;
    //         cur = cur.right;
    //         return ret;
    //     }

    //     public boolean hasNext() {
    //         return cur != null || !stack.isEmpty();
    //     }
    // }

    public static void main(String[] args){
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur=new TreeNode(1);
        cur.left=new TreeNode(2);
        cur.right=new TreeNode(3);
        cur.left.left=new TreeNode(4);
        cur.right.left=new TreeNode(5);
        cur.right.right=new TreeNode(6);

        while(cur!=null||!stack.isEmpty()){
            while (cur != null) {
                System.out.println(cur.val);
                stack.addFirst(cur);
                cur = cur.left;
            }
            cur = stack.removeFirst();
            cur = cur.right;
        }   
    }

}

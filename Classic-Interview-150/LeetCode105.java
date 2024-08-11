// 前序和中序构造二叉树
import java.util.Deque;
import java.util.LinkedList;


public class LeetCode105 {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // return buildTreeCore(preorder, inorder, 0, 0, preorder.length);

        // 迭代法，借助栈，根本想不到，而且挺难理解的
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorder[i]);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorder[i]);
                stack.push(node.right);
            }
        }
        return root;

    }

    // private TreeNode buildTreeCore(int[] preorder, int[] inorder, int pre, int in, int len) {
    //     if (len == 0)
    //         return null;
    //     TreeNode node = new TreeNode(preorder[pre]);
    //     int index = in;
    //     for (; index < in + len; index++) {
    //         if (inorder[index] == preorder[pre])
    //             break;
    //     }
    //     node.left = buildTreeCore(preorder, inorder, pre + 1, in, index - in);
    //     node.right = buildTreeCore(preorder, inorder, pre + 1 + index - in, in +
    //             index - in + 1, len - index + in - 1);
    //     return node;
    // }
}

// 中序和后续遍历二叉树

public class LeetCode106 {
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeCore(inorder, postorder, 0, 0, inorder.length);

    }

    private TreeNode buildTreeCore(int[] inorder, int[] postorder, int in, int post, int len) {
        if (len <= 0)
            return null;
        TreeNode node = new TreeNode(postorder[post + len - 1]);
        int index = in;
        for (; index < in + len; index++) {
            if (inorder[index] == node.val)
                break;
        }
        int leftLen = index - in;
        int rightLen = len - leftLen - 1;
        node.left = buildTreeCore(inorder, postorder, in, post, leftLen);
        node.right = buildTreeCore(inorder, postorder, in + leftLen + 1, post + leftLen, rightLen);
        return node;

        // 迭代法，借助栈，从后往前遍历，就和根据前序和中序恢复树一模一样
        // Deque<TreeNode> stack = new LinkedList<>();
        // TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        // stack.push(root);
        // int inorderIndex = inorder.length - 1;
        // for (int i = postorder.length - 2; i >= 0; i--) {
        //     TreeNode node = stack.peek();
        //     if (node.val != inorder[inorderIndex]) {
        //         node.right = new TreeNode(postorder[i]);
        //         stack.push(node.right);
        //     } else {
        //         while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
        //             inorderIndex--;
        //             node = stack.pop();
        //         }
        //         node.left = new TreeNode(postorder[i]);
        //         stack.push(node.left);
        //     }
        // }
        // return root;
    }
}

import java.util.ArrayList;

public class LeetCode236 {

    // 自己想的方法：先后序遍历找到节点路径，最后遍历路径寻找共同祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();
        postOrder(root, p, path1);
        postOrder(root, q, path2);
        for (TreeNode node1 : path1) {
            for (TreeNode node2 : path2) {
                if (node1 == node2) {
                    return node1;
                }
            }
        }
        return null;
    }

    public boolean postOrder(TreeNode root, TreeNode node, ArrayList<TreeNode> path) {
        if (root == null) {
            return false;
        }
        if (root == node) {
            path.add(root);
            return true;
        }
        if (postOrder(root.left, node, path)) {
            path.add(root);
            return true;
        }
        if (postOrder(root.right, node, path)) {
            path.add(root);
            return true;
        }
        return false;
    }

    // 网上看到的方法
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     if (root == null) {
    //         return null;
    //     }
    //     if (root == p || root == q) {
    //         return root;
    //     }
    //     TreeNode left = lowestCommonAncestor(root.left, p, q);
    //     TreeNode right = lowestCommonAncestor(root.right, p, q);
    //     if (left != null && right != null) {
    //         return root;
    //     }
    //     return left != null ? left : right;
    // }
}

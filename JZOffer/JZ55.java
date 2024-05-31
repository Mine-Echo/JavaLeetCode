//二叉树的深度
public class JZ55 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        public TreeNode(int val) {
            this.val = val;
    
        }
    
    }
    public int TreeDepth(TreeNode root) {
        if(root==null)
            return 0;
        int left,right;
        left=TreeDepth(root.left);
        right=TreeDepth(root.right);
        return Math.max(left, right)+1;
    }
}

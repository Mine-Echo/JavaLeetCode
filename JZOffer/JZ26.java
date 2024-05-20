//树的子结构
public class JZ26 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        public TreeNode(int val) {
            this.val = val;
    
        }
    
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        //遍历
        if(root1==null||root2==null)
            return false;
        if(root1.val==root2.val)
            if(isMatch(root1, root2))
                return true;
        if(HasSubtree(root1.left, root2))
            return true;
        if(HasSubtree(root1.right, root2))
            return true;
        return false;
    }

    public boolean isMatch(TreeNode root1,TreeNode root2) {
        //比较
        if(root2==null)
            return true;
        if(root1==null&&root2!=null)
            return false;
        if(root1.val==root2.val){
            return isMatch(root1.left, root2.left)&&isMatch(root1.right, root2.right);
        }else{
            return false;
        }
    }
}
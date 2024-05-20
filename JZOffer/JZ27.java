//二叉树的镜像
public class JZ27 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param pRoot TreeNode类
     * @return TreeNode类
     */
    public TreeNode Mirror(TreeNode pRoot) {
        // write code here
        //递归版本
        if (pRoot==null)
            return null;
        TreeNode left =pRoot.left;
        pRoot.left=Mirror(pRoot.right);
        pRoot.right=Mirror(left);
        return pRoot;
        //也可以用队列来做（层序遍历的思想）
    }
}
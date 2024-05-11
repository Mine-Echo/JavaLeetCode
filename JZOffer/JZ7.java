//重建二叉树


public class JZ7 {

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
     * @param preOrder int整型一维数组
     * @param vinOrder int整型一维数组
     * @return TreeNode类
     */
    public TreeNode reConstructBinaryTree(int[] preOrder, int[] vinOrder) {
        // write code here
        return construct(preOrder, 0, vinOrder, 0, preOrder.length);
    }

    public TreeNode construct(int[] preOrder,int preStart, int[] vinOrder,int vinStart, int length){
        if(length==0)
            return null;
        if(length==1)
            return new TreeNode(preOrder[preStart]);
        int rootVal=preOrder[preStart];
        int rootIndex=0;
        for(int i=vinStart;i<vinStart+length;i++){
            if(vinOrder[i]==rootVal){
                rootIndex=i;
            }
        }
        TreeNode root=new TreeNode(rootVal);
        root.left=construct(preOrder, preStart+1, vinOrder, vinStart, rootIndex-vinStart);
        root.right=construct(preOrder, preStart+1+rootIndex-vinStart, vinOrder, rootIndex+1, length-rootIndex+vinStart-1);
        return root;
    }
}
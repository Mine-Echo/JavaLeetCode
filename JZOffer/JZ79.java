//判断是否为平衡二叉树
import java.util.Map;
import java.util.AbstractMap;
public class JZ79 {

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
     * @return bool布尔型
     */
    public boolean IsBalanced_Solution(TreeNode pRoot) {
        // write code here
        Map.Entry<Boolean, Integer> result = isBalanced(pRoot);
        return result.getKey();
    }

    private Map.Entry<Boolean,Integer> isBalanced(TreeNode node){
        if(node==null)
            return new AbstractMap.SimpleEntry<Boolean,Integer>(true,0);
        Map.Entry<Boolean, Integer> left,right;
        left=isBalanced(node.left);
        right=isBalanced(node.right);
        int depth=Math.max(left.getValue(), right.getValue())+1;
        if((!left.getKey())||(!left.getKey())){//子树不平衡
            return new AbstractMap.SimpleEntry<Boolean,Integer>(false,depth);
        }
        if(((left.getValue()-right.getValue())>1)||((left.getValue()-right.getValue())<-1))//当前节点不平衡
            return new AbstractMap.SimpleEntry<Boolean,Integer>(false,depth);
        else
            return new AbstractMap.SimpleEntry<Boolean,Integer>(true,depth); 
    } 
}
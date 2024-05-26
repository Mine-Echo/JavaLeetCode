//二叉搜索树转双向链表
import java.util.List;
import java.util.ArrayList;
public class JZ36 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        public TreeNode(int val) {
            this.val = val;
    
        }
    
    }
    // //自己想的一个中序遍历的方法，很愚蠢且复杂，明明可以先中序遍历把节点存到一个list里，再弄指针
    // public TreeNode Convert(TreeNode pRootOfTree) {
    //     //中序遍历就是二叉搜索树从小到大的顺序
    //     if(pRootOfTree ==null)
    //         return null;
    //     TreeNode node=new TreeNode(pRootOfTree.val);
    //     node.left=leftSubTree(pRootOfTree.left);
    //     if(node.left!=null)
    //         node.left.right=node;
    //     node.right=rightSubTree(pRootOfTree.right);
    //     if(node.right!=null)
    //         node.right.left=node;
    //     //返回链表头
    //     while(node.left!=null)
    //         node=node.left;
    //     return node;
    // }
    // private TreeNode leftSubTree(TreeNode left){
    //     if(left==null)
    //         return null;
    //     TreeNode node=new TreeNode(left.val);
    //     node.left=leftSubTree(left.left);
    //     if(node.left!=null)
    //         node.left.right=node;
    //     node.right=rightSubTree(left.right);
    //     if(node.right!=null)
    //         node.right.left=node;
    //     while(node.right!=null){
    //         node=node.right;
    //     }
    //     return node;
        
    // }
    // private TreeNode rightSubTree(TreeNode right){
    //     if(right==null)
    //         return null;
    //     TreeNode node=new TreeNode(right.val);
    //     node.left=leftSubTree(right.left);
    //     if(node.left!=null)
    //         node.left.right=node;
    //     node.right=rightSubTree(right.right);
    //     if(node.right!=null)
    //         node.right.left=node;
    //     while(node.left!=null){
    //         node=node.left;
    //     }
    //     return node;
    // }
    //实现一下先中序遍历把节点存到一个list里，再弄指针
    private List<TreeNode> result=new ArrayList<>();
    public TreeNode Convert(TreeNode pRootOfTree) {
        result.clear();
        //中序遍历
        inOrder(pRootOfTree);
        return arrangePtr();
    }
    private void inOrder(TreeNode node) {
        if(node==null)
            return;
        inOrder(node.left);
        result.add(node);
        inOrder(node.right);
    }
    private TreeNode arrangePtr(){
        if(result.isEmpty())
            return null;
        for(int i=0;i < result.size();i++){
            if(i!=0)
                result.get(i).left=result.get(i-1);
            else
                result.get(i).left=null;
            if(i!=result.size()-1)
                result.get(i).right=result.get(i+1);
            else
                result.get(i).right=null;
        }
        return result.get(0);
    }
}

//二叉树的下一个节点

import java.util.ArrayList;

public class JZ8 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // //遍历这个二叉树，将遍历顺序储存到数组里面，然后从数组中找下一个
        // //但是感觉并不是最好的做法，还是有很多可以优化的方向的
        TreeLinkNode root = pNode;
        //先找到根节点
        while(root.next!=null){
            root=root.next;
        }
        //然后中序遍历
        ArrayList<TreeLinkNode> list=new ArrayList<>();
        inOrder(root, list);
        //找到下一个节点
        int index=0;
        for(index=0;index<list.size();index++){
            if(list.get(index).val==pNode.val){
                break;
            }
        }
        if(index<list.size()-1)
            return list.get(index+1);
        return null;

        //大概看了下网上的解法，跟我之前想的差不多
        //就是分类讨论该节点的情况
        //我自己实现一下
        // if(pNode==null)
        //     return pNode;

        // if(pNode.right!=null){
        //     //如果有右子节点，下一个就是右子节点的最左边的子辈
        //     pNode=pNode.right;
        //     while(pNode.left!=null){
        //         pNode=pNode.left;
        //     }
        //     return pNode;
        // }else{
        //     //没有右子节点，那么下一个节点是自己的父辈
        //     while(pNode.next!=null){
        //         if(pNode.next.left==pNode){
        //             return pNode.next;
        //         }else{
        //             pNode=pNode.next;
        //         }
        //     }
        //     return null;
        // }
    }

    private void inOrder(TreeLinkNode node, ArrayList<TreeLinkNode> list){
        if(node==null)
            return;
        inOrder(node.left,list);
        list.add(node);
        inOrder(node.right,list);
    }
}

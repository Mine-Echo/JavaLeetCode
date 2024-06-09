//序列化二叉树

import java.util.*;

public class JZ37 {

    // private TreeNode dummyNode=new TreeNode(-1);

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    String Serialize(TreeNode root) {
        // 可以用先序遍历和中序遍历来序列化
        ArrayList<Integer> pre=new ArrayList<>();
        ArrayList<Integer> in=new ArrayList<>();
        preOrder(root, pre);
        inOrder(root, in);
        StringBuilder sb=new StringBuilder();
        sb.append('{');
        for(int i=0;i < pre.size();i++){
            sb.append(Integer.toString(pre.get(i)));
            if(i!=pre.size()-1)
                sb.append(',');
        }
        sb.append('}');
        sb.append('{');
        for(int i=0;i < in.size();i++){
            sb.append(Integer.toString(in.get(i)));
            if(i!=in.size()-1)
                sb.append(',');
        }
        sb.append('}');
        return sb.toString();

        //网上看到的做法就是用层序遍历来做
        // Queue<TreeNode> q=new LinkedList<>();
        // StringBuilder sb=new StringBuilder();
        // if(root==null)
        //     return "";
        // q.add(root);
        // while(!q.isEmpty()){
        //     TreeNode node=q.poll();
        //     if(node!=root){
        //         sb.append(',');
        //     }
        //     sb.append(node.val);
        //     if(node!=dummyNode){
        //         q.add(node.left==null?dummyNode:node.left);
        //         q.add(node.right==null?dummyNode:node.right);
        //     }
        // }
        // return sb.toString();
    }

    TreeNode Deserialize(String str) {
        // 根据先序遍历和中序遍历的结果反序列化
        // 跟之前做过的那道根据中序遍历和先序遍历还原二叉树的题目一样
        int boundary=str.indexOf('}', 0);
        String spre=str.substring(1, boundary-1);
        String sin=str.substring(boundary+1, str.length()-1);
        if(spre.equals(""))
            return null;
        String[] pres=spre.split(",");
        String[] ins=sin.split(",");
        int[] pre=new int[pres.length];
        int[] in=new int[ins.length]; 
        for (int i = 0; i < pre.length; i++) {
            pre[i]=Integer.parseInt(pres[i]);
            in[i]=Integer.parseInt(ins[i]);
        }
        return construct(pre, 0, pre.length, in, 0, in.length);

        // if(str.equals(""))
        //     return null;
        // String[] s=str.split(",");
        // Integer[] vals=new Integer[s.length];
        // Queue<TreeNode> q=new LinkedList<>();
        // for (int i = 0; i < s.length; i++) {
        //     vals[i]=Integer.parseInt(s[i]);
        // }
        // TreeNode root=new TreeNode(vals[0]);
        // q.add(root);
        // for(int i=1;i<s.length;i+=2){
        //     TreeNode node=q.poll();
        //     if(vals[i]!=-1){
        //         TreeNode left=new TreeNode(vals[i]);
        //         node.left=left;
        //         q.add(left);
        //     }
        //     if(vals[i+1]!=-1){
        //         TreeNode right =new TreeNode(vals[i +1]);
        //         node.right=right;
        //         q.add(right);
        //     }
        // }
        // return root;
    }   

    private TreeNode construct(int[] pre,int pstart,int pend,int[] in,int istart,int iend){
        if(pstart>=pend)
            return null;
        TreeNode node=new TreeNode(pre[pstart]);
        int index;
        for(index=istart;index<iend;index++){
            if(in[index]==node.val)
                break;
        }
        node.left=construct(pre, pstart+1, pstart+1+index-istart, in, istart, index);
        node.right=construct(pre, pstart+1+index-istart, pend, in, index+1, iend);
        return node;
    }

    private void preOrder(TreeNode node, ArrayList<Integer> result) {
        if (node == null)
            return;
        result.add(node.val);
        preOrder(node.left, result);
        preOrder(node.right, result);
    }

    private void inOrder(TreeNode node, ArrayList<Integer> result) {
        if (node == null)
            return;
        inOrder(node.left, result);
        result.add(node.val);
        inOrder(node.right, result);
    }
}

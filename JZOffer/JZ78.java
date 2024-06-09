//把二叉树打印成多行

import java.util.*;

public class JZ78 {

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
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        // write code here
        // 和普通的层序遍历稍微有点区别，每一层需要分开
        // 可以用两个队列
        // Queue<TreeNode> q1 = new LinkedList<>();
        // Queue<TreeNode> q2 = new LinkedList<>();
        // ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        // if (pRoot == null)
        //     return ret;
        // q1.add(pRoot);
        // while (!q1.isEmpty() || !q2.isEmpty()) {
        //     ArrayList<Integer> list = new ArrayList<>();
        //     if (!q1.isEmpty()) {
        //         while (!q1.isEmpty()) {
        //             TreeNode node = q1.poll();
        //             list.add(node.val);
        //             if (node.left != null)
        //                 q2.add(node.left);
        //             if (node.right != null)
        //                 q2.add(node.right);
        //         }
        //     } else {
        //         while (!q2.isEmpty()) {
        //             TreeNode node = q2.poll();
        //             list.add(node.val);
        //             if (node.left != null)
        //                 q1.add(node.left);
        //             if (node.right != null)
        //                 q1.add(node.right);
        //         }
        //     }
        //     ret.add(list);
        // }
        // return ret;

        // 阿秀笔记上看到可以用一个队列做
        // 我想的方法还是稍微复杂了一点
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (pRoot == null)
            return ret;
        q.add(pRoot);
        while (!q.isEmpty()) {
            int len = q.size();// 每一层的长度
            ArrayList<Integer> list = new ArrayList<>();
            while (len > 0) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                len--;
            }
            ret.add(list);
        }
        return ret;
    }
}
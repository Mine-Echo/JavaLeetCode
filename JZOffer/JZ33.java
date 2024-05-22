//二叉搜索树的后序遍历序列

import java.util.Arrays;

public class JZ33 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length ==0)
            return false;
        return check(sequence);
    }

    private boolean check(int [] sequence) {
        if (sequence.length ==0)
            return true;
        //最后一个元素是根节点
        int root=sequence[sequence.length - 1];
        //前面的元素能分为左子树和右子树
        int split=0;
        while(sequence[split] < root){
            split++;
        }
        //判断是否符合搜索二叉树的大小关系
        for(int i=split;i<sequence.length-1;i++){
            if(sequence[i]<root)
                return false;
        }
        //递归判断
        int [] left=Arrays.copyOfRange(sequence, 0, split);
        int [] right = Arrays.copyOfRange(sequence,split,sequence.length-1);
        return check(left)&&check(right);
    }
}

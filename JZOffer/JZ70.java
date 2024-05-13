//矩阵覆盖
public class JZ70 {
    public int rectCover(int target) {
        //递归，依然类似斐波那契数列
        // if(target==0)
        //     return 0;
        // if(target==1)
        //     return 1;
        // if (target ==2)
        //     return 2;
        // return rectCover(target - 1)+rectCover(target-2);
        if(target==0)
            return 0;
        if(target==1)
            return 1;
        if (target ==2)
            return 2;
        int x1=1,x2=2,ret=0;
        for(int i=2;i<target;i++){
            ret=x1+x2;
            x1=x2;
            x2=ret;
        }
        return ret;
    }
}

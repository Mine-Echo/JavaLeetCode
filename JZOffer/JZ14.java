//剪绳子

public class JZ14 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param n int整型
     * @return int整型
     */
    public int cutRope(int n) {
        // write code here

        // 感觉可以递归，但是复杂度太高了
        // if (n <= 3)
        //     return n - 1;
        // return core(n);

        // 感觉可以dp，刚开始不知道怎么dp
        // 看了阿秀笔记上的dp思路
        // if (n <= 3)
        //     return n - 1;
        // int[] dp=new int[n+1];
        // dp[0]=1;
        // dp[1]=1;
        // dp[2]=2;
        // dp[3]=3;
        // for(int i=4;i<=n;i++){
        //     for(int j=1;j<=i/2;j++){
        //         dp[i]=Math.max(dp[i], dp[j]*dp[i-j]);
        //     }
        // }
        // return dp[n];

        //另一种偏向数学的思路
        //根据规律优先拆分成3，其次是2
        if (n <= 3)
            return n - 1;
        if(n%3==1){
            //拆成2*2*一堆3
            return 2*2*(int)Math.pow(3, (n-4)/3);
        }else if(n%3==2){
            //拆成2*一堆3
            return 2*(int)Math.pow(3, (n-2)/3);
        }else{
            //拆成3*3*...
            return (int)Math.pow(3,n/3);
        }
    }

    // private int core(int n) {
    //     if (n == 1 || n == 0)
    //         return 1;
    //     int max = 0;
    //     for (int i = 1; i <= n; i++) {
    //         int mul = i * cutRope(n - i);
    //         if (mul > max)
    //             max = mul;
    //     }
    //     return max;
    // }
}
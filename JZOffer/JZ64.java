//求1+2+3+...+n

public class JZ64 {
    public int Sum_Solution(int n) {
        // 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
        // 不会，除非能用乘除或者if
        // return ((n+1)*n)/2;

        // 网上看到的方法
        // 不用if，利用逻辑表达式的短路特性实现递归中止，从未想过还能这样
        int ret = 0;
        boolean con = (n > 0) && ((ret = n + Sum_Solution(n - 1)) == 0);
        return ret;
    }
}
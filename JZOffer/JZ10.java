public class JZ10 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param n int整型
     * @return int整型
     */
    public int Fibonacci(int n) {
        // write code here
        if (n == 1 || n == 2)
            return 1;
        int x1 = 1, x2 = 1, ret = 0;
        for (int i = 2; i < n; i++) {
            ret = x1 + x2;
            x1 = x2;
            x2 = ret;
        }
        return ret;
    }
}
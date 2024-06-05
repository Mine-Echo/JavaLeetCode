//构建乘积数组
public class JZ66 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param A int整型一维数组
     * @return int整型一维数组
     */
    public int[] multiply(int[] A) {
        // write code here
        // 要求不能用除法
        // 我想到一个On的方法，肯定比直接暴力On2的方法好一点
        int[] mul1 = new int[A.length];
        int[] mul2 = new int[A.length];
        int mul = 1;
        for (int i = 0; i < A.length; i++) {
            mul1[i] = mul;
            mul *= A[i];
        }
        mul = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            mul2[i] = mul;
            mul *= A[i];
        }
        int[] ret = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            ret[i] = mul1[i] * mul2[i];
        }
        return ret;
    }
}
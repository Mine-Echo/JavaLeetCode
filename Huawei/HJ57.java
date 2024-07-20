
//高精度整数加法
import java.util.Scanner;
import java.math.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ57 {
    public static void main(String[] args) {
        // 方法1：直接调用BigInteger库
        // Scanner in = new Scanner(System.in);
        // BigInteger num1 = in.nextBigInteger();
        // BigInteger num2 = in.nextBigInteger();
        // System.out.println(num1.add(num2));
        // in.close();

        // 方法2：模拟加法
        Scanner in = new Scanner(System.in);
        String num1 = in.nextLine();
        String num2 = in.nextLine();
        in.close();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < Math.max(num1.length(), num2.length()); i++) {
            int result = carry;
            if (i < num1.length())
                result += num1.charAt(i) - 48;
            if (i < num2.length())
                result += num2.charAt(i) - 48;
            carry = result / 10;
            sb.append(result % 10);
        }
        if (carry != 0)
            sb.append(carry);
        sb.reverse();
        System.out.println(sb.toString());
    }
}
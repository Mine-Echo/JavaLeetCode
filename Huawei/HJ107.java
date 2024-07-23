
//求解立方根
import java.util.Scanner;

public class HJ107 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double num = in.nextDouble();
        // double dif = Double.MAX_VALUE;
        // double result = 0;
        // for (double i = -20; i <= 20; i += 0.1) {
        // if (Math.abs(num - i * i * i) < dif) {
        // result = i;
        // dif = Math.abs(num - i * i * i);
        // }
        // }
        // System.out.println(String.format("%.1f", result));
        double left = -20.0, right = 20.0, mid = 0.0;
        while (right - left >= 0.01) {
            mid = (left + right) / 2;
            if (mid * mid * mid > num) {
                right = mid;
            } else if (mid * mid * mid < num) {
                left = mid;
            } else {
                break;
            }
        }
        System.out.println(String.format("%.1f", mid));

        in.close();
    }
}
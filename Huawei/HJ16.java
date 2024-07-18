
//购物单
import java.util.Scanner;
import java.util.*;

public class HJ16 {
    public static void main(String[] args) {
        // 改进版的背包问题，动态规划
        // 让附件都依赖于主件，不能让其单独存在
        // 网上看到的思路如下，自己实现了一下，还debug了好久，太难了
        // 让w[i][0]表示第i个主键的价格，w[i][j]代表该主件第j个附件的价格，没有则为0
        // 让v[i][0]表示第i个主键的价值，w[i][j]代表该主件第j个附件的价值，没有则为0
        // 放的时候在主键能放的情况下才放附件
        Scanner in = new Scanner(System.in);
        int money = in.nextInt() / 10;
        int num = in.nextInt();
        int[] price = new int[num];
        int[] weight = new int[num];
        int[] master = new int[num];
        // 附件的下标数组
        ArrayList<Integer> slave = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            price[i] = in.nextInt() / 10;
            weight[i] = in.nextInt();
            master[i] = in.nextInt();
            if (master[i] != 0)
                slave.add(i);
        }
        // 创建只有主件的数组，v[i][0]代表主件价值，v[i][1]代表其附件1的价值...
        int numOfMaster = num - slave.size();
        int[][] v = new int[numOfMaster][3];
        int[][] w = new int[numOfMaster][3];
        // 主件从原始下标映射到只有主键数组的下标
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < num; i++) {
            if (master[i] == 0) {
                v[index][0] = price[i] * weight[i];
                w[index][0] = price[i];
                map.put(i, index++);
            }
        }
        for (int i : slave) {
            index = map.get(master[i] - 1);
            if (v[index][1] == 0) {
                v[index][1] = price[i] * weight[i];
                w[index][1] = price[i];
            } else if (v[index][2] == 0) {
                v[index][2] = price[i] * weight[i];
                w[index][2] = price[i];
            }
        }

        // 数据处理完毕，创建dp数组
        int[][] dp = new int[numOfMaster][money + 1];
        // 初始化dp数组
        for (int j = 0; j < money + 1; j++) {
            if (j >= w[0][0]) {
                dp[0][j] = v[0][0];
                // 只放附件1
                if (v[0][1] != 0 && j >= w[0][0] + w[0][1])
                    dp[0][j] = Math.max(dp[0][j],
                            v[0][0] + v[0][1]);
                // 只放附件2
                if (v[0][2] != 0 && j >= w[0][0] + w[0][2])
                    dp[0][j] = Math.max(dp[0][j],
                            v[0][0] + v[0][2]);
                // 两个附件都放
                if (v[0][1] != 0 && v[0][2] != 0 && j >= w[0][0] + w[0][1] + w[0][2])
                    dp[0][j] = Math.max(dp[0][j],
                            v[0][0] + v[0][1] + v[0][2]);
            }
        }
        // 动态规划方程求解
        for (int i = 1; i < numOfMaster; i++) {
            for (int j = 0; j < money + 1; j++) {
                if (j >= w[i][0]) {
                    dp[i][j] = Math.max(dp[i - 1][j],
                            dp[i - 1][j - w[i][0]] + v[i][0]);
                    // 两个附件都放
                    if (v[i][1] != 0 && v[i][2] != 0 && j >= w[i][0] + w[i][1] + w[i][2])
                        dp[i][j] = Math.max(dp[i][j],
                                dp[i - 1][j - w[i][0] - w[i][1] - w[i][2]] + v[i][0] + v[i][1] + v[i][2]);
                    // 只放附件1
                    if (v[i][1] != 0 && j >= w[i][0] + w[i][1])
                        dp[i][j] = Math.max(dp[i][j],
                                dp[i - 1][j - w[i][0] - w[i][1]] + v[i][0] + v[i][1]);
                    // 只放附件2
                    if (v[i][2] != 0 && j >= w[i][0] + w[i][2])
                        dp[i][j] = Math.max(dp[i][j],
                                dp[i - 1][j - w[i][0] - w[i][2]] + v[i][0] + v[i][2]);
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        System.out.print(dp[numOfMaster - 1][money] * 10);
        in.close();
    }
}
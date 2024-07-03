// 加油站

public class LeetCode134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        // 暴力解超时
        // int len = gas.length;
        // int gas_cnt = 0, cost_cnt = 0;
        // for (int i = 0; i < len; i++) {
        //     gas_cnt += gas[i];
        //     cost_cnt += cost[i];
        // }
        // if (gas_cnt < cost_cnt)
        //     return -1;
        // for (int i = 0; i < len; i++) {
        //     int total = 0;
        //     for (int j = 0; j < len; j++) {
        //         int index = (i + j) % len;
        //         total += gas[index];
        //         if (total < cost[index]) {
        //             total = -1;
        //             break;
        //         } else {
        //             total -= cost[index];
        //         }
        //     }
        //     if (total >= 0)
        //         return i;
        // }
        // return -1;

        // 重要的性质：(可以数学推导证明)
        // 从加油站 x 出发，每经过一个加油站就加一次油（包括起始加油站），最后一个可以到达的加油站是 y
        // 从 x,y 之间的任何一个加油站出发，都无法到达加油站 y 的下一个加油站
        int i = 0;
        int n = gas.length;
        while (i < n) {
            int gasSum = 0, costSum = 0;
            int j = 0;
            while (gasSum >= costSum) {
                int index = (i + j) % n;
                gasSum += gas[index];
                costSum += cost[index];
                j++;
                if (j == n + 1)
                    break;
            }
            if (j == n + 1)
                return i;
            else if (i + j < n)
                i = (j + i);
            else
                break;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = { 2, 3, 4 };
        int[] cost = { 3, 4, 3 };
        canCompleteCircuit(gas, cost);
    }
}
//分发糖果

import java.util.Arrays;

public class LeetCode135 {
    public static int candy(int[] ratings) {
        // 左右各遍历一次，第一次满足左比右小情况下的糖果分配，第二次满足左比右大情况下的糖果分配
        // int[] cd = new int[ratings.length];
        // Arrays.fill(cd, 1);
        // for (int i = 1; i < cd.length; i++) {
        //     if (ratings[i] > ratings[i - 1]) {
        //         cd[i] = cd[i - 1] + 1;
        //     }
        // }
        // for (int i = cd.length - 2; i >= 0; i--) {
        //     if (ratings[i] > ratings[i + 1]) {
        //         cd[i] = Math.max(cd[i + 1] + 1, cd[i]);
        //     }
        // }
        // int min = 0;
        // for (int i = 0; i < cd.length; i++) {
        //     min += cd[i];
        // }
        // return min;

        // 另一个方法：空间数组法
        // 可以把空间复杂度降到O(1)

        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] can={1,2,87,87,87,2,1};
        System.out.println(candy(can));
    }
}

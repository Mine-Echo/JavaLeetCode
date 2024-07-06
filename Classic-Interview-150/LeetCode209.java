//长度最小的子数组

import java.util.Arrays;

public class LeetCode209 {
    public int minSubArrayLen(int target, int[] nums) {
        // 暴力解法,超时
        // int n = nums.length;
        // if (n == 0) {
        //     return 0;
        // }
        // int min = Integer.MAX_VALUE;
        // for (int i = 0; i < n; i++) {
        //     int sum = 0;
        //     for (int j = i; j < n; j++) {
        //         sum += nums[j];
        //         if (sum >= target) {
        //             min = Math.min(min, j - i + 1);
        //             break;
        //         }
        //     }
        // }
        // return min == Integer.MAX_VALUE ? 0 : min;

        // 题解看到的滑动窗口法,这种思想得记住
        int left = 0, right = -1;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length - 1) {
            right++;
            sum += nums[right];
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}


//最长连续序列
import java.util.*;

public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        // 先排序再统计
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int max = 1;
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                cnt++;
                max = cnt > max ? cnt : max;
            } else if (nums[i] != nums[i - 1]) {
                cnt = 1;
            }
        }
        return max;

        // 使用Set，时间复杂度为On
        // Set<Integer> set = new HashSet<Integer>();
        // for (int num : nums) {
        //     set.add(num);
        // }
        // int max = 0;
        // for (Integer num : set) {
        //     if (!set.contains(num - 1)) {
        //         int cnt = 0;
        //         while (set.contains(num)) {
        //             cnt++;
        //             num++;
        //         }
        //         max = cnt > max ? cnt : max;
        //     }
        // }
        // return max;
    }
}

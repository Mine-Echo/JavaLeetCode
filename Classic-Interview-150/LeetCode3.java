//无重复字符的最长字串

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;;

public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        // 自己想的双指针解法，时间复杂度On2，有很多重复的计算，速度击败15%用户，内存击败99%用户
        // int left = 0, right = 0, max = 0;
        // while (right < s.length()) {
        //     right++;
        //     int i = left;
        //     for (; i < right - 1; i++) {
        //         if (s.charAt(i) == s.charAt(right - 1)) {
        //             left = i + 1;
        //         }
        //     }
        //     max = Math.max(max, right - left);
        // }
        // return max;

        // 看了官方题解后，给我的解法做一个改进，用hashmap来保存位置,理论上是On，执行速度超过78%
        int left = 0, right = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            right++;
            Character ch = s.charAt(right - 1);
            if (map.containsKey(ch)) {
                int pos = map.get(ch);
                if (pos >= left) {
                    left = map.get(ch) + 1;
                } else {
                    max = Math.max(max, right - left);
                }
            } else {
                max = Math.max(max, right - left);
            }
            map.put(ch, right - 1);
        }
        return max;

        // 网上看到速度最快的代码，和我的算法思想一样，不过用数组而不是hashmap存，而且写的也比我简洁多了
        // char[] c = s.toCharArray();
        // int[] pos = new int[128];
        // Arrays.fill(pos, -1);
        // int res = 0;

        // for (int i = 0, j = 0; i < c.length; i++) {
        //     j = Math.max(j, pos[c[i]] + 1);
        //     res = Math.max(res, i - j + 1);
        //     pos[c[i]] = i;
        // }

        // return res;
    }
}

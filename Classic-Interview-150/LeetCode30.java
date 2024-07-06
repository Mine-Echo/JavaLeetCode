//串联所有单词的字串

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class LeetCode30 {
    public List<Integer> findSubstring(String s, String[] words) {
        // 比较暴力的解法，超时
        // List<Integer> result = new ArrayList<>();
        // int n = words.length, m = words[0].length();
        // int len = m * n;
        // Map<String, Integer> map = new HashMap<>();
        // for (int i = 0; i < words.length; i++) {
        //     if (map.containsKey(words[i])) {
        //         map.put(words[i], map.get(words[i]) + 1);
        //     } else {
        //         map.put(words[i], 1);
        //     }
        // }
        // for (int i = 0; i < s.length() - len + 1; i++) {
        //     String seq = s.substring(i, i + len);
        //     Map<String, Integer> copy = new HashMap<>(map);
        //     for (int j = 0; j < len; j += m) {
        //         String subSeq = seq.substring(j, j + m);
        //         if (copy.containsKey(subSeq)) {
        //             if (copy.get(subSeq) == 1) {
        //                 copy.remove(subSeq);
        //             } else {
        //                 copy.put(subSeq, copy.get(subSeq) - 1);
        //             }
        //         } else {
        //             break;
        //         }
        //     }
        //     if (copy.isEmpty())
        //         result.add(i);
        // }
        // return result;

        // 参考了网上解答后，自己实现了一下滑动窗口法
        // 之前就大概想到滑动窗口了，但是想到每次移动1个单位的话都要重置left/right，就感觉和暴力差不多了
        // 没有想到可以在外面套一层循环，然后滑动窗口每次都移动m个单位来简化滑动窗口
        List<Integer> result = new ArrayList<>();
        int n = words.length, m = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        // 滑动窗口每次都以m长度增加，所以最外层需要这样一个循环使得所有情况都能遍历到
        for (int i = 0; i < m; i++) {
            Map<String, Integer> copy = new HashMap<>(map);
            int left = i, right = i;
            int current = 0;
            while (right < s.length() - m + 1) {
                String subStr = s.substring(right, right + m);
                if (copy.getOrDefault(subStr, 0) > 0) {
                    // 匹配上
                    current++;
                    copy.put(subStr, copy.get(subStr) - 1);
                    right += m;
                    if (current == n) {
                        result.add(left);
                    }
                } else {
                    // 没有匹配上
                    if (current == 0) {
                        left = right = right + m;
                    } else {
                        current--;
                        String removeStr = s.substring(left, left + m);
                        copy.put(removeStr, copy.get(removeStr) + 1);
                        left += m;
                    }
                }
            }
        }
        return result;
    }
}

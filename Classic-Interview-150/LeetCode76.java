//最小覆盖子串

import java.util.HashMap;
import java.util.Map;

public class LeetCode76 {
    public String minWindow(String s, String t) {
        int left = 0, right = 0;
        String min = null;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int cnt = 0;
        while (right < s.length()) {
            right++;
            char ch = s.charAt(right - 1);
            if (map.getOrDefault(ch, 0) > 0) {
                cnt++;
                map.put(ch, map.get(ch) - 1);
                if (cnt == t.length()) {
                    // 找到全部，移动左指针寻找最小覆盖
                    char leftChar = s.charAt(left);
                    while (!map.containsKey(leftChar) || map.get(leftChar) < 0) {
                        if (map.containsKey(s.charAt(left))) {
                            map.put(leftChar, map.get(leftChar) + 1);
                        }
                        left++;
                        leftChar = s.charAt(left);
                    }
                    // 更新最小串
                    min = min == null || min.length() > right - left ? s.substring(left, right) : min;
                    map.put(s.charAt(left), 1);
                    cnt--;
                    left++;
                }
            } else {
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) - 1);
                }

            }
        }
        return min == null ? "" : min;
    }
}

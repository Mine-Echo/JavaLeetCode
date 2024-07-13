
//有效的字母异位词
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

public class LeetCode242 {
    public boolean isAnagram(String s, String t) {
        // 时间复杂度On，但实际leetcode上测试的速度还没有排序的方法快
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        for (int i = 0; i < sChar.length; i++) {
            map.put(sChar[i], map.getOrDefault(sChar[i], 0) + 1);
        }
        for (int i = 0; i < tChar.length; i++) {
            if (map.getOrDefault(tChar[i], 0) > 0) {
                map.put(tChar[i], map.get(tChar[i]) - 1);
            } else {
                return false;
            }
        }
        return true;

        // 排序，时间复杂度Onlogn
        // if (s.length() != t.length()) {
        //     return false;
        // }
        // char[] str1 = s.toCharArray();
        // char[] str2 = t.toCharArray();
        // Arrays.sort(str1);
        // Arrays.sort(str2);
        // return Arrays.equals(str1, str2);
    }
}

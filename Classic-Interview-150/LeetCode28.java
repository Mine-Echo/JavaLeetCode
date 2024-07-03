//找出字符串中第一个匹配项的下标
public class LeetCode28 {
    public int strStr(String haystack, String needle) {
        // 直接调用库函数
        // return haystack.indexOf(needle, 0);

        // 自己实现一下，比库函数慢
        for (int i = 0; i < haystack.length(); i++) {
            int isMatch = 1;
            for (int j = 0; j < needle.length(); j++) {
                if (i+j>=haystack.length()||haystack.charAt(i + j) != needle.charAt(j)) {
                    isMatch = 0;
                    break;
                }
            }
            if (isMatch == 1)
                return i;
        }
        return -1;
    }
}

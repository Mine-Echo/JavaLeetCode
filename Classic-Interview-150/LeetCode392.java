//判断子序列
public class LeetCode392 {
    public static boolean isSubsequence(String s, String t) {
        // 双指针
        int sp = 0;
        int tp = 0;
        while (sp < s.length() && tp < t.length()) {
            if (s.charAt(sp) == t.charAt(tp)) {
                tp++;
                sp++;
            } else {
                tp++;
            }
        }
        if (sp == s.length())
            return true;
        else
            return false;

        // dp的方法 f[i][j]表示从t中第i个字符开始，j字符第一次出现的位置
        // int n = s.length(), m = t.length();

        // int[][] f = new int[m + 1][26];
        // for (int i = 0; i < 26; i++) {
        //     f[m][i] = m;
        // }

        // for (int i = m - 1; i >= 0; i--) {
        //     for (int j = 0; j < 26; j++) {
        //         if (t.charAt(i) == j + 'a')
        //             f[i][j] = i;
        //         else
        //             f[i][j] = f[i + 1][j];
        //     }
        // }
        // int add = 0;
        // for (int i = 0; i < n; i++) {
        //     if (f[add][s.charAt(i) - 'a'] == m) {
        //         return false;
        //     }
        //     add = f[add][s.charAt(i) - 'a'] + 1;
        // }
        // return true;
    }

    public static void main(String[] args) {

    }
}

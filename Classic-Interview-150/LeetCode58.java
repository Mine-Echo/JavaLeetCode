//最后一个单词的长度
public class LeetCode58 {
    public int lengthOfLastWord(String s) {
        // 方法一直接调用split函数
        // String[] words=s.split(" ");
        // return words[words.length-1].length();

        // 这个方法更快一点
        int cnt = 0, start = s.length() - 1;
        for (; start >= 0; start--) {
            if (s.charAt(start) != ' ')
                break;
        }
        for (; start >= 0; start--) {
            if (s.charAt(start) != ' ')
                cnt++;
            else
                break;
        }
        return cnt;
    }
}
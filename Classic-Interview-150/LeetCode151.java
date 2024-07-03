//反转字符串中的单词

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode151 {
    public static String reverseWords(String s) {
        String[] words=s.trim().split("\\s+");
        StringBuilder result =new StringBuilder();
        for (int i = words.length-1; i >= 0; --i) {
            if(i!=words.length-1)
                result.append(' ');
            result.append(words[i]);           
        }
        return result.toString();
        

        // // 除去开头和末尾的空白字符
        // s = s.trim();
        // // 正则匹配连续的空白字符作为分隔符分割
        // List<String> wordList = Arrays.asList(s.split("\\s+"));
        // Collections.reverse(wordList);
        // return String.join(" ", wordList);
    }

    public static void main(String[] args){
        String s="  hello world  ";
        System.out.println(reverseWords(s)+"111");
    }
}

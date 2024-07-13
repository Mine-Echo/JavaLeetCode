
//单词规律
import java.util.Map;
import java.util.HashMap;

public class LeetCode290 {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        char[] chars = pattern.toCharArray();
        Map<Character, String> ch2str = new HashMap<>();
        Map<String, Character> str2ch = new HashMap<>();
        if (words.length != chars.length)
            return false;
        for (int i = 0; i < words.length; i++) {
            if (ch2str.containsKey(chars[i])){
                if (!ch2str.get(chars[i]).equals(words[i]))
                    return false;
            }else{
                ch2str.put(chars[i],words[i]);
            }
            if(str2ch.containsKey(words[i])){
                if (!str2ch.get(words[i]).equals(chars[i])){
                    return false;
                }
            }else{
                str2ch.put(words[i],chars[i]);
            }
        }
        return true;
    }
}

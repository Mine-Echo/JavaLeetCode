//同构字符串
import java.util.Map;
import java.util.HashMap;

public class LeetCode205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t=new HashMap<>();
        Map<Character, Character> t2s=new HashMap<>();
        char[] sChar=s.toCharArray();
        char[] tChar=t.toCharArray();
        for (int i = 0; i < sChar.length; i++) {
            if(s2t.containsKey(sChar[i])){
                if(s2t.get(sChar[i])!=tChar[i]){
                    return false;
                }
            }else{
                s2t.put(sChar[i], tChar[i]);
            }
            if(t2s.containsKey(tChar[i])){
                if(s2t.get(tChar[i])!=sChar[i]){
                    return false;
                }
            }else{
                t2s.put(tChar[i], sChar[i]);
            }
        }
        return true;
    }
}

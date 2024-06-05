//字符流中第一个不重复的字符

import java.util.*;

public class JZ75 {

    private StringBuilder sb=new StringBuilder();

    // Insert one char from stringstream
    public void Insert(char ch) {
        sb.append(ch);
    }

    // return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        //我用HashMap来记录，也可以用一个128大小的数组来记录，因为ASCII字符范围为0-127
        Map<Character, Integer> map=new HashMap<>();
        for(int i=0;i<sb.length();i++){
            char ch= sb.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }
        for (int i=0;i<sb.length();i++){
            if(map.get(sb.charAt(i))==1){
                return sb.charAt(i);
            }
        }
        return '#';
    }
}

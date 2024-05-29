//第一个只出现一次的字符
import java.util.*;
public class JZ50 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param str string字符串 
     * @return int整型
     */
    public int FirstNotRepeatingChar (String str) {
        // write code here
        //用map，也可以用vector
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch= str.charAt(i);
            if(map.containsKey(ch))
                map.put(ch,map.get(ch)+1);
            else
                map.put(ch,1);
        }
        for(int i=0;i<str.length();i++){
            if(map.get(str.charAt(i))==1)
                return i;
        }
        return -1;

        //网上看到的一种方法，用字符串操作函数indexOf 和lastIndexOf
        // for (int i = 1;i<str.length();i++){
        //     if(str.indexOf(str.charAt(i))==str.lastIndexOf(str.charAt(i))){
        //         return i;
        //     }
        // }
        // return -1;
    }
}
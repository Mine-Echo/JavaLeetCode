//快乐数

import java.util.*;

public class LeetCode202 {
    public boolean isHappy(int n) {
        Map<Integer,Boolean> map=new HashMap<>();
        while (n != 1) {
            if(map.containsKey(n))
                return false;
            else
                map.put(n, true);
            int sum = 0;
            while (n != 0) {
                sum+=(int)Math.pow(n%10,2);
                n/=10;
            }
            n = sum;
        }
        return true;
    }
}
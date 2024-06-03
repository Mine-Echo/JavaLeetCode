//和为S的连续正数序列
import java.util.*;
public class JZ74 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param sum int整型 
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence (int sum) {
        // write code here
        // 要求时间复杂度为线性，用两个指针来做，一个指向求和起始数字，一个指向求和终止数字
        // 不断移动终止位置的指针，如果超过sum就移动起始数字，相等就记录下来
        int low=0,high=0,s=0;
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        for(high=0;(high<=100)&&(high<sum);high++){
            s+=high;
            while(s>sum){
                ++low;
                s-=low;
            }
            if(s==sum){
                ArrayList<Integer> list=new ArrayList<>();
                for(int i=low+1;i<=high;i++)
                    list.add(i);
                res.add(list);
            }
        }
        return res;
    }
}
//把数组排成最小的数
import java.util.*;
public class JZ45 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param numbers int整型一维数组 
     * @return string字符串
     */
    public String PrintMinNumber (int[] numbers) {
        // write code here
        //看了网上的解法，两两比较排序即可，比较要拼接起来比较
        String[] nums=new String[numbers.length];
        for(int i=0;i < numbers.length; i ++)
            nums[i]=Integer.toString(numbers[i]);
        Arrays.sort(nums,new Comparator<String>() {
            @Override
            public int compare(String s1,String s2){
                int a=Integer.parseInt(s1+s2);
                int b=Integer.parseInt(s2+s1);
                return a>b?1:-1;
            }           
        });
        StringBuilder result=new StringBuilder();
        for (String num : nums) {
            result.append(num);
        }
        return result.toString();
    }
}
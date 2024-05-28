//小丑数
import java.util.*;


public class JZ49 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param index int整型 
     * @return int整型
     */
    public int GetUglyNumber_Solution (int index) {
        // write code here
        //看了网上的思路
        //最让我搞不懂的是为什么UglyNumber=2^x*3^y*5^z
        //查了一下原因，大概是这个定理：任何一个大于1的自然数，如果不是质数，都可以表示为几个质数的乘积，这几个质数称为该整数的质因数（质数只能表示为1*本身，所以质数的质因子只有一个，就是他本身）
        //然后就有一种很巧妙的方法，用四个数组和三个指针
        //写了以后看了别人的实现，发现还是写复杂了一点，其实只要三个指针一个数组就行了，还是太菜了

        //第一到六个丑数就是1~6
        if(index<=6)
            return index;
        List<Integer> result=new ArrayList<>();
        List<Integer> list_2=new ArrayList<>();
        List<Integer> list_3=new ArrayList<>(); 
        List<Integer> list_5=new ArrayList<>();
        result.add(1);
        list_2.add(2);
        list_3.add(3);
        list_5.add(5);
        int i=0,j=0,k=0;
        while(result.size()<index){
            int m=(min(list_2.get(i),list_3.get(j),list_5.get(k)));
            if(list_2.get(i)==m) i++;
            if(list_3.get(j)==m) j++;
            if(list_5.get(k)==m) k++;
            list_2.add(m*2);
            list_3.add(m*3);
            list_5.add(m*5);
            result.add(m);
        }
        return result.get(index-1);
    }

    private int min(int a,int b,int c){
        if(a<=b&&a<=c)
            return a;
        if(b<=a&&b<=c)
            return b;
        return c;
    }
}
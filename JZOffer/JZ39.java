//数组中超过半数的数
// import java.util.HashMap;
// import java.util.Map;
// import java.util.Set;
public class JZ39 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param numbers int整型一维数组 
     * @return int整型
     */
    public int MoreThanHalfNum_Solution (int[] numbers) {
        // write code here
        //刚开始想着先全存到map中再遍历map找符合标准的，后面发现可以边存边找
        // int boundary=numbers.length/2;
        // Map<Integer, Integer> map=new HashMap<>();
        // for (int number : numbers) {
        //     map.put(number,map.get(number)==null?1:map.get(number)+1);
        //     if(map.get(number)>boundary)
        //         return number;
        // }
        // return -1;

        //摩尔投票法：就是让选票互相抵消，在本题中，最后剩下的那个肯定是，所以不需要扫描第二次验证（因为题目说一定有大于半数的
        int number=0,cnt=0;
        for(int n:numbers){
            if(cnt==0){
                number=n;
                cnt=1;
            }else if(number==n){
                cnt++;
            }else{
                cnt--;
            }
        }
        return number;
    }
}
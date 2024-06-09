//滑动窗口的最大值
import java.util.*;

public class JZ59 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param num int整型一维数组 
     * @param size int整型 
     * @return int整型ArrayList
     */
    public ArrayList<Integer> maxInWindows (int[] num, int size) {
        // write code here
        //暴力解法
        // ArrayList<Integer> list=new ArrayList<>();
        // if(num.length<size||num.length==0||size==0)
        //     return list;
        // int max=0;
        // for(int i=0;i<num.length-size+1; i++){
        //     max=num[i];
        //     for(int j=i+1;j<i+size;j++){
        //         max=max>=num[j]?max:num[j];
        //     }
        //     list.add(max);
        // }
        // return list;

        //牛客上看到的解法，确实牛,自己实现了一下
        //用双向队列来做，存下标，队列中从头到尾，元素逐渐减小，下标逐渐增大
        //遍历数组的每一个元素，
        //如果容器为空，则直接将当前元素加入到容器中。
        //如果容器不为空，则让当前元素和容器的最后一个元素比较，如果大于，则将容器的最后一个元素删除，然后继续讲当前元素和容器的最后一个元素比较
        //如果当前元素小于容器的最后一个元素，则直接将当前元素加入到容器的末尾
        //如果容器头部的元素已经不属于当前窗口的边界，则应该将头部元素删除
        ArrayList<Integer> list=new ArrayList<>();
        if(num.length<size||num.length==0||size==0)
            return list;
        Deque<Integer> q=new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            if(q.isEmpty()){
                q.add(i);
            }else {
                while(!q.isEmpty()&&num[q.getLast()]<num[i]){
                    //不仅下标比它新，元素还比它大，那队列的末尾元素就无任何意义了
                    q.pollLast();
                }
                q.addLast(i);
                //如果头部的最大的元素的下标已经移出窗口，则移除头部元素
                if(q.peekFirst()<i-size+1){
                    q.pollFirst();
                }
            }
            if(i>=size-1)
                    list.add(num[q.peekFirst()]);
        }
        return list;
    }
}
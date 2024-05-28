//找出最小的k个数
import java.util.*;

public class JZ40 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param input int整型一维数组 
     * @param k int整型 
     * @return int整型ArrayList
     */
    public ArrayList<Integer> GetLeastNumbers_Solution (int[] input, int k) {
        // write code here
        //本来想用treemap，但是treemap会去重，不满足要求
        // TreeMap<Integer,Integer>map=new TreeMap<>();
        // ArrayList<Integer>list=new ArrayList<>();
        // for(int i=0;i<input.length;i++){
        //     map.put(input[i], input[i]);
        // }
        // for(int i=0;i<k;i++){
        //     Entry<Integer,Integer> entry=map.pollFirstEntry();
        //     list.add(entry.getKey());
        // }
        // return list;
        
        //直接使用堆
        PriorityQueue<Integer> q=new PriorityQueue<>();
        for(int i=0;i<input.length;i++){
            q.add(input[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<k;i++){
            list.add(q.poll());
        }
        return list;
    }
}

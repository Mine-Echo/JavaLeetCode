//数据流中的中位数
import java.util.*;

public class JZ41 {

    // private ArrayList<Integer> list=new ArrayList<>();
    private Queue<Integer> max_q=new PriorityQueue<>(Comparator.reverseOrder());
    private Queue<Integer> min_q=new PriorityQueue<>();
    public void Insert(Integer num) {
        //在插入的时候进行插入排序
        // int index;
        // list.add(num);//防止越界，set方法不会自动扩容
        // for(index=list.size()-2;index>=0;index--){
        //     if(list.get(index)>num){
        //         list.set(index+1, list.get(index));
        //     }else {
        //         break;
        //     }
        // }
        // list.set(index+1,num);

        //牛客上看到的很好的解法
        //用两个堆（一个最大堆，一个最小堆）存数据
        //最大堆放1~median-1 最小堆放median+1~n median放哪里无所谓
        
        //先加入最大堆，再将最大堆中最大的元素加入最小堆，防止循序关系错乱
        max_q.add(num);
        min_q.add(max_q.poll());
        //平衡一下两个堆
        if(min_q.size()>max_q.size())
            max_q.add(min_q.poll());
    }

    public Double GetMedian() {
        // double median=0;
        // if(list.size()%2==1){
        //     median=list.get(list.size()/2);
        // }else{
        //     median=(list.get(list.size()/2)+list.get(list.size()/2-1))/2.0;
        // }
        // return median;

        if(min_q.size()==max_q.size()){
            return (max_q.peek()+min_q.peek())/2.0;
        }else{
            return max_q.peek().doubleValue();
        }
    }


}

//复杂链表的深度拷贝

import java.util.ArrayList;
import java.util.List;

public class JZ35 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;
    
        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead) {
        //感觉写的比较复杂
        //阿秀笔记上看到可以用map写，那个比较简单，我用c++实现了
        if(pHead==null)
            return null;
        RandomListNode r =pHead;
        RandomListNode copy=new RandomListNode(0);//dummy
        RandomListNode now=copy;
        RandomListNode last;
        List<RandomListNode> origin=new ArrayList<>();
        List<RandomListNode> copyList=new ArrayList<>();
        //先拷贝除了随机指针外的所有元素
        while(r!=null){
            last=now;
            now=new RandomListNode(r.label);
            last.next=now;
            copyList.add(now);
            origin.add(r);
            r=r.next;
        }
        copy=copy.next;
        //拷贝随机指针
        for(int i=0;i<origin.size();i++){
            for(int j=0;j<origin.size();j++){
                if(origin.get(i).random!=null&&origin.get(i).random.hashCode()==origin.get(j).hashCode()){
                    copyList.get(i).random=copyList.get(j);
                    break;
                }
            }
        }
        return copy;
    }

}

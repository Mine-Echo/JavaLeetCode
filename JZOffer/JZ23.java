
//链表中环的入口节点
import java.util.*;

public class JZ23 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        // 可以用map存放节点
        // Map<ListNode, Integer> map = new HashMap<>();
        // while (pHead != null) {
        //     if (!map.containsKey(pHead)) {
        //         map.put(pHead, 1);
        //     } else {
        //         return pHead;
        //     }
        //     pHead = pHead.next;
        // }
        // return pHead;

        // 网上看到又可以用双指针来做，牛客上的精华讲解，原理比较偏向数学
        // 通过定义slow和fast指针，slow每走一步，fast走两步，
        // 若是有环，则一定会在环的某个结点处相遇（slow == fast）
        // 然后可以通过画图分析出相遇点到入口节点的距离等于链表头到入口点的距离

        // 其实讲解没提到的一点就是两个指针一定会在慢指针进入环后的一圈内相遇(这样才能够根据讲解上的那个图分析出结论)
        // 因为快指针每次都比慢指针多走一步，所以每次行走都能缩小一步与慢指针之间的距离
        // 假设极端情况慢指针在进入环时与快指针之间的距离刚好是 一圈-1，即快指针指向慢指针的前一个结点
        // 由于慢指针走一圈快指针能追一圈的距离，所以快指针也能够在慢指针走一圈内追上
        if(pHead==null||pHead.next==null)
            return null;
        
        ListNode slow=pHead,fast=pHead;
        while(fast != null&&fast.next !=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return null;
        }
        while(pHead!=slow){
            pHead=pHead.next;
            slow=slow.next;
        }
        return pHead;
    }
}

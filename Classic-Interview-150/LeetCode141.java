
//环形链表
import java.util.*;

public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        // 方法一：可以用set存储hashcode
        Set<Integer> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head.hashCode()))
                return true;
            set.add(head.hashCode());
            head = head.next;
        }
        return false;

        // 方法二：快慢指针
        // ListNode slow = head, fast = head;
        // while (slow != null && fast != null && fast.next != null) {
        //     slow = slow.next;
        //     fast = fast.next.next;
        //     if (slow == fast)
        //         return true;
        // }
        // return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

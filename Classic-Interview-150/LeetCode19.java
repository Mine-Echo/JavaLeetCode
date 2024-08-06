//删除链表的倒数第N个节点

public class LeetCode19 {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 用两个指针实现一遍遍历
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode slow = dummyHead, fast = head;
        int dif = 0;
        while (dif < n) {
            fast = fast.next;
            dif++;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}

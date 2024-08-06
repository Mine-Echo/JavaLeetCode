//K个一组链表反转

public class LeetCode25 {

    public static class ListNode {
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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode node = dummyHead;
        int cnt = 0;
        while (node.next != null) {
            if (cnt % k == 0) {
                if (!reverseList(node, k)) {
                    reverseList(node, k);
                }
            }
            node = node.next;
            cnt++;
        }
        return dummyHead.next;
    }

    private boolean reverseList(ListNode dummyHead, int len) {
        ListNode last = dummyHead, node = dummyHead.next, next = null;
        int cnt = 0;
        while (cnt < len && node != null) {
            next = node.next;
            node.next = last;
            last = node;
            node = next;
            cnt++;
        }
        dummyHead.next.next = next;
        dummyHead.next = last;
        return cnt == len;
    }

    public static void main(String[] args) {
        LeetCode25 l = new LeetCode25();
        ListNode head = new LeetCode25.ListNode(1), node = head;
        node.next = new LeetCode25.ListNode(2);
        node = node.next;
        node.next = new LeetCode25.ListNode(3);
        node = node.next;
        node.next = new LeetCode25.ListNode(4);
        node = node.next;
        node.next = new LeetCode25.ListNode(5);
        node = node.next;
        head=l.reverseKGroup(head, 2);
        head=null;
    }
}

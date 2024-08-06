//删除链表中的重复元素II
//我参加字节二面出了这道题

public class LeetCode82 {
    public class ListNode {
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

    public ListNode deleteDuplicates(ListNode head) {
        // 一次遍历
        ListNode dummyHead = new ListNode(0, head);
        ListNode node = head, last = dummyHead;
        while (node != null) {
            if (node.next != null && node.val == node.next.val) {
                int val = node.val;
                while (node != null && node.val == val) {
                    node = node.next;
                }
            } else {
                last.next = node;
                last = node;
                node = node.next;
            }
        }
        last.next = null;
        return dummyHead.next;
    }
}

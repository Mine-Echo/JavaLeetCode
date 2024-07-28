//反转链表

public class LeetCode92 {

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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 先找到反转的位置，用三个指针反转
        ListNode dummyHead = new ListNode(0), node = dummyHead;
        node.next = head;
        int index = 1;
        while (index < left) {
            node = node.next;
            index++;
        }
        ListNode leftNode = node, last = null, next = null;
        node = node.next;
        // 翻转链表
        while (index <= right) {
            next = node.next;
            node.next = last;
            last = node;
            node = next;
            index++;
        }
        // 拼接right位置
        leftNode.next.next = node;
        // 拼接left位置
        leftNode.next = last;
        return dummyHead.next;
    }
}

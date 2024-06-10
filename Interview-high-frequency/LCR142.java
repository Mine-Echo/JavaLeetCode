//训练计划IV

class LCR142 {

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

    public ListNode trainningPlan(ListNode l1, ListNode l2) {
        // 经典的merge
        ListNode node = new ListNode(-1);// dummy head
        ListNode head = node;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                node.next = l2;
                node = node.next;
                l2 = l2.next;
            } else {
                node.next = l1;
                node = node.next;
                l1 = l1.next;
            }
        }
        if (l1 != null)
            node.next = l1;
        else
            node.next = l2;
        return head.next;
    }
}
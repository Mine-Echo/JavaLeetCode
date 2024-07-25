
public class LeetCode21 {

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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(), node = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                node.next = list2;
                node = node.next;
                list2 = list2.next;
            } else {
                node.next = list1;
                node = node.next;
                list1 = list1.next;
            }
        }
        while (list1 != null) {
            node.next = list1;
            node = node.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            node.next = list2;
            node = node.next;
            list2 = list2.next;
        }
        return dummy.next;
    }
}

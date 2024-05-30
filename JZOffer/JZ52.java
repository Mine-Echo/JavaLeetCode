//链表的公共节点

public class JZ52 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        // 暴力遍历，比较的时候比较hashCode（地址）而不是val
        // while (pHead1 != null) {
        //     ListNode node = pHead2;
        //     while (node != null) {
        //         if (pHead1.hashCode() == node.hashCode())
        //             return node;
        //         node = node.next;
        //     }
        //     pHead1 = pHead1.next;
        // }
        // return null;

        // 网上看到的大神解法
        // 两个指针走自己的路，再走别人的路
        // 如果有公共节点，则会在公共节点相遇（两条路一样长就会在走自己的路时相遇，否则在走别人的路时相遇）
        // 如果没有公共节点，则最终都走到null
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        while (node1 != node2) {
            node1 = (node1 == null) ? pHead2 : node1.next;
            node2 = (node2 == null) ? pHead1 : node2.next;
        }
        return node2;
    }
}

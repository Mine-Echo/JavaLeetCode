//旋转链表

public class LeetCode61 {
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

    public ListNode rotateRight(ListNode head, int k) {
        // 方法一：先统计长度，再找到位置，进行断开连接操作
        if (k == 0 || head == null || head.next == null)
            return head;
        ListNode node = head;
        int len = 1;
        while (node.next != null) {
            node = node.next;
            len++;
        }
        int n = k % len;
        ListNode ptr = head;
        for (int i = 0; i < len - n - 1; i++) {
            ptr = ptr.next;
        }
        node.next = head;
        ListNode ret = ptr.next;
        ptr.next = null;
        return ret;

        // 方法二：先连成环，再断开，和方法一几乎没有差别
        // if (k == 0 || head == null || head.next == null)
        //     return head;
        // ListNode node = head;
        // int len = 1;
        // while (node.next != null) {
        //     node = node.next;
        //     len++;
        // }
        // int n = k % len;
        // // 连成环
        // node.next = head;
        // node = head;
        // for (int i = 0; i < len - n - 1; i++) {
        //     node = node.next;
        // }
        // // 断开
        // ListNode ret = node.next;
        // node.next = null;
        // return ret;

        // 方法三：先总体翻转，再前面部分翻转，再后部分翻转，实现略
    }
}

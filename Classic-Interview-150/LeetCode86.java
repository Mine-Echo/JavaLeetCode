//分割链表

public class LeetCode86 {
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

    public ListNode partition(ListNode head, int x) {
        // 自己想的通过原地修改链表的方法
        ListNode dummyHead = new ListNode(0, head);
        ListNode last = dummyHead, node = head;
        while (node != null) {
            if (node.val >= x) {
                // last.next到node为>=x的链表段
                while (node.next != null && node.next.val >= x) {
                    node = node.next;
                }
                ListNode begin = node.next, end = node.next;
                // begin到end为<x的链表段
                if (end != null)
                    while (end.next != null && end.next.val < x) {
                        end = end.next;
                    }
                if (begin != null) {
                    // 交换两个链表段的位置
                    node.next = end.next;
                    end.next = last.next;
                    last.next = begin;
                    last = end; // 调整last位置
                } else {
                    // 已经是末尾了
                    node = node.next;
                }
            } else {
                last = node;
                node = node.next;
            }
        }
        return dummyHead.next;

        // 官方给的解法：维护small和large两个链表
        // ListNode small = new ListNode(0);
        // ListNode smallHead = small;
        // ListNode large = new ListNode(0);
        // ListNode largeHead = large;
        // while (head != null) {
        //     if (head.val < x) {
        //         small.next = head;
        //         small = small.next;
        //     } else {
        //         large.next = head;
        //         large = large.next;
        //     }
        //     head = head.next;
        // }
        // large.next = null;
        // small.next = largeHead.next;
        // return smallHead.next;
    }
}

//删除链表倒数第n个节点

public class LCR021 {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        /**
         * 简单的方法
         * 遍历两次
         * 第一次统计长度/位置
         * 第二次找到并删除
         */
        /**
         * 进阶方法
        * 用两个间隔n的指针
        * 遍历一次即可
        */
        if(n==0)
            return null;
        ListNode front = head;
        ListNode back=head;
        while(front.next!=null){
            front=front.next;
            if(n<=0){
                back=back.next;
            }
            n--;
        }
        //删除head
        if(n==1){
            return head.next;
        }
        //超出界限
        if(n>1){
            return null;
        }
        //删除back后面一个指针
        back.next=back.next.next;
        return head;
    }
}

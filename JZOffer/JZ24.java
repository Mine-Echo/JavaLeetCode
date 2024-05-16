//反转链表

public class JZ24 {
    public class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param head ListNode类 
     * @return ListNode类
     */
    public ListNode ReverseList (ListNode head) {
        // write code here
        //用三个指针实现链表反转
        if(head==null||head.next==null)
            return head;
        ListNode n1=head,n2=head.next,n3=head.next.next;
        head.next=null;
        while(n3!=null){
            //反向连接
            n2.next=n1;
            n1=n2;
            n2=n3;
            n3=n3.next;
        }
        n2.next=n1;
        return n2;
        //另一种方法头插法，用C++实现了
    }
}
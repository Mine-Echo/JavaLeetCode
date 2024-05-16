//合并两个有序链表
 public class JZ25 {
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
     * @param pHead1 ListNode类 
     * @param pHead2 ListNode类 
     * @return ListNode类
     */
    public ListNode Merge (ListNode pHead1, ListNode pHead2) {
        // write code here
        //经典的merge算法
        ListNode head =new ListNode(0),dummy=head;
        while(pHead1!=null&&pHead2!=null){
            if(pHead1.val>pHead2.val){
                head.next=pHead2;
                pHead2=pHead2.next;
            }else{
                head.next=pHead1;
                pHead1=pHead1.next;
            }
            head=head.next;
        }
        if(pHead1!=null)
            head.next=pHead1;
        else
            head.next=pHead2;
        head=dummy.next;
        return head;
    }
}
//删除链表中的重复节点
public class JZ76 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        //用三个指针last，node，next不断删除，用dummy node简化第一个节点的判断
        //但还是调试了很多遍才过，有些细节还是挺复杂且容易忽略的
        int delete=0;
        if(pHead==null||pHead.next==null)
            return pHead;
        ListNode node=pHead;
        pHead=new ListNode(0);//dummy node
        pHead.next=node;
        ListNode last=pHead;
        ListNode next;
        while(node!=null&&node.next != null){
            if(node.val==node.next.val){
                delete=node.val;
                while(node!=null&&node.val==delete){
                    next=node.next;
                    last.next=next;
                    node=next;
                }
                // last=last.next;
            }else{
                last=node;
                node=node.next;
            }
                
        }
        return pHead.next;
    }
}

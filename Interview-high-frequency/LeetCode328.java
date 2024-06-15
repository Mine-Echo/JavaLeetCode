//奇偶链表

class Solution {

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

    public ListNode oddEvenList(ListNode head) {
        // 一边遍历一边操作，指针操作稍微有点繁琐，容易弄错
        ListNode oddHead = new ListNode();// dummy node
        ListNode evenHead = new ListNode();
        ListNode lastOdd = oddHead;
        ListNode lastEven = evenHead;
        while (head != null) {
            lastOdd.next = head;
            lastOdd = head;
            if (head.next != null) {
                lastEven.next = head.next;
                lastEven = head.next;
            } else {
                lastEven.next = null;
                break;
            }
            head = head.next.next;
        }
        lastOdd.next = evenHead.next;
        return oddHead.next;

        // 别人的解法，本质没啥区别，看上去代码简单一点，但稍微难理解一点
        // if (head == null || head.next == null)
        //     return head;
        // ListNode first = head;
        // ListNode second = head.next;
        // ListNode evenHead = second;
        // while (second != null && second.next != null) {
        //     first.next = second.next;
        //     second.next = second.next.next;
        //     first = first.next;
        //     second = second.next;
        // }
        // first.next = evenHead;
        // return head;
    }
}
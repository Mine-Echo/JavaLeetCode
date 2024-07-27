
//随机链表的复制
import java.util.*;

public class LeetCode138 {

    public Node copyRandomList(Node head) {
        Node dummyHead = new Node(-1), node1 = dummyHead;
        Node node2 = head;
        Map<Node, Node> map = new HashMap<>();
        while (node2 != null) {
            node1.next = new Node(node2.val);
            node1 = node1.next;
            map.put(node2, node1);
            node2 = node2.next;
        }
        node1 = dummyHead.next;
        node2 = head;
        while (node1 != null) {
            node1.random = map.get(node2.random);
            node1 = node1.next;
            node2 = node2.next;
        }
        return dummyHead.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
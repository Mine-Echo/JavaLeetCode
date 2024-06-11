
//LRU缓存
import java.util.*;

//使用HashMap+双向链表
class LRUCache {

    private class ListNode {
        int val;
        int key;
        ListNode next;
        ListNode last;

        ListNode() {
            this.val = -1;
            this.key = -1;
            next = null;
            last = null;
        }

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.last = null;
        }

        ListNode(int key, int val, ListNode last, ListNode next) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.last = last;
        }
    }

    Map<Integer, ListNode> map;
    ListNode head, tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new ListNode();// dummy node
        this.tail = new ListNode();// dummy node
        head.next = tail;
        tail.last = head;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        ListNode ret = map.get(key);
        if (ret == null)// 无元素
            return -1;
        else {
            // 将元素移到链表头部
            moveToHead(ret);
            return ret.val;
        }
    }

    public void put(int key, int value) {
        ListNode ret = map.get(key);
        if (ret == null) {
            // 没找到
            // 判断是否超容量
            if (map.size() >= capacity) {
                // 移除末尾的元素
                map.remove(tail.last.key);
                tail.last.last.next = tail;
                tail.last = tail.last.last;
            }
            // 需要插入头部
            ListNode node = new ListNode(key, value, head, head.next);
            head.next.last = node;
            head.next = node;
            map.put(key, node);

        } else {
            ret.val = value;
            // 需要插入头部
            moveToHead(ret);
        }
    }

    private void moveToHead(ListNode node){
        node.last.next = node.next;
        node.next.last = node.last;
        node.last = head;
        node.next = head.next;
        head.next = node;
        node.next.last = node;
    }
}

//也可以用LinkedHashMap
//LinkedHashMap可以保存插入的顺序
//写起来简单很多，但是速度不如上面那种方法
// class LRUCache {
//     int capacity;
//     Map<Integer, Integer> map;

//     public LRUCache(int capacity) {
//         this.capacity = capacity;
//         map = new LinkedHashMap<>();
//     }

//     public int get(int key) {
//         if (map.containsKey(key)) {
//             int value = map.remove(key);
//             map.put(key, value);
//             return value;
//         } else {
//             return -1;
//         }
//     }

//     public void put(int key, int value) {
//         if (map.containsKey(key)) {
//             map.remove(key);
//         }
//         map.put(key, value);
//         if (map.size() > capacity) {
//             // 移除第一个元素
//             map.remove(map.entrySet().iterator().next().getKey());
//         }
//     }
// }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

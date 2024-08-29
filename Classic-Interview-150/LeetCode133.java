
//克隆图
import java.util.*;

public class LeetCode133 {
    Map<Integer, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        return dfs(node);
    }

    public Node dfs(Node src) {
        Node dst = new Node(src.val);
        visited.put(src.val, dst);
        for (Node node : src.neighbors) {
            if (!visited.containsKey(node.val)) {
                dst.neighbors.add(dfs(node));
            } else {
                dst.neighbors.add(visited.get(node.val));
            }
        }
        return dst;
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}

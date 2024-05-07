package claasic150;

import java.util.*;

public class CloneGraph {
    static class Node {
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

    public static Node cloneGraph(Node node){
        if(node == null || node.neighbors == null) {
            return node;
        }
        Map<Node, Node> nodes = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        nodes.put(node, new Node(node.val));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            List<Node> tns = cur.neighbors;
            for (Node neighbor : tns
            ) {
                if(!nodes.containsKey(neighbor)) {
                    nodes.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                nodes.get(cur).neighbors.add(nodes.get(neighbor));
            }
        }
        return nodes.get(node);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        Node temp = cloneGraph(node1);
        System.out.println(node1.neighbors);
    }
}

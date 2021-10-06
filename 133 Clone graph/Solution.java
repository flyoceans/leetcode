/*
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
*/

// BFS
// HashMap<old, new> 
// Queue<Node>
// if visited, pass
// else traversal child, update hashmap
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        map.put(node, new Node(node.val));
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            Node copy = map.get(tmp);
            for (Node next : tmp.neighbors) {
                if (map.containsKey(next)) {
                    copy.neighbors.add(map.get(next));
                } else {
                    Node cp = new Node(next.val);
                    copy.neighbors.add(cp);
                    map.put(next, cp);
                    queue.add(next);
                }
            }
        }
        
        return map.get(node);
        
    }
}
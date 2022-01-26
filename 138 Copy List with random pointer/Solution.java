/*
// Definition for a Node.
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
*/

// Map<Node, Node> map
// Traversal list, 
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        map.put(head, new Node(head.val));
        
        Node original = head;
        while (original.next != null) {
            Node nextCopy = new Node(original.next.val);
            map.get(original).next = nextCopy;
            map.put(original.next, nextCopy);
            original = original.next;
        }
        original = head;
        while (original != null) {
            if (original.random != null)
                map.get(original).random = map.get(original.random);
            original = original.next; 
        }
        return map.get(head);
    }
}
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
        Node res = head;
        while (head.next != null) {
            Node next = new Node(head.next.val);
            map.get(head).next = next;
            map.put(head.next, next);
            head = head.next;
        }
        head = res;
        while (head != null) {
            if (head.random != null)
                map.get(head).random = map.get(head.random);
            head = head.next; 
        }
        return map.get(res);
    }
}
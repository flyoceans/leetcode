/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        
        RandomListNode h = head;
        while (head != null) {
            RandomListNode cp = new RandomListNode(head.label);
            cp.next = head.next;
            head.next = cp;
            head = cp.next;
        }
        head = h;
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
        head = h;
        RandomListNode pesudo = h.next;
        RandomListNode c = pesudo;
        while (head != null) {
            head.next = c.next;
            if (c.next != null)
                c.next = head.next.next;
            else {
                c.next = null;
                break;
            }
            head = head.next;
            c = c.next;
        }
        return pesudo;
    }
}
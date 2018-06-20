/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode p = findMid(head);
        ListNode mid = p.next;
        p.next = null;
        // System.out.print(mid.val);
        ListNode reverseMid = reverse(mid);
        // System.out.print(reverseMid.val);
        while (head != null) {
            ListNode p1 = head.next;
            ListNode p2 = reverseMid.next;
            head.next = reverseMid;
            head = p1;
            if (head == null) {
                break;
            }
            reverseMid.next = p1;
            reverseMid = p2;
        }
        return;
    }
    
    private ListNode findMid(ListNode p) {
        ListNode dummy = new ListNode(0);
        dummy.next = p;
        ListNode fast = dummy, slow = dummy;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode p) {
        ListNode pre = null;
        while (p.next != null) {
            ListNode tmp = p.next;
            p.next = pre;
            pre = p;
            p = tmp;
        }
        p.next = pre;
        return p;
    }
}
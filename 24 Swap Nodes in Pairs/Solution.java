/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode nex = head.next;

        while (cur != null && nex != null) {
            ListNode tmp = nex.next;
            pre.next = nex;
            nex.next = cur;
            cur.next = tmp;
            pre = cur;
            cur = tmp;
            if (tmp == null) break;
            nex = tmp.next;
          
        }
        return dummy.next;
    }
}
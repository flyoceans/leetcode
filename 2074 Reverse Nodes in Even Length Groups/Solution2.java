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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        help(dummy, 1);
        return dummy.next;
    }
    
    private void help(ListNode head, int x) {
        ListNode tmpNode = head;
        int cnt = 0; // how many node left
        while (tmpNode.next != null) {
            tmpNode = tmpNode.next;
            cnt++;
            if (cnt == x) break;
        }
        if (cnt < x) {
            if (cnt > 0 && cnt % 2 == 0) reverse(head, cnt); // corner case [0,4,2,1,3]
            return;
        }
        if (x % 2 == 0) {
            reverse(head, x);
            cnt = x;
            while (cnt > 0) {
                head = head.next;
                cnt--;
            }
            help(head, x + 1);
        } else 
            help(tmpNode, x + 1);
    }
    
    public ListNode reverse(ListNode head, int x) {
        ListNode pre = head;
        ListNode mid = pre.next;
        ListNode cur = mid.next;
        
        for (int i = 1; i < x; i++) {
            mid.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = mid.next;
        }
        return mid;
    }
}
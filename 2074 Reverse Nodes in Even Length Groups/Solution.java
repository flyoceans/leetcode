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
// Use Deque
class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode ret = head;
        ListNode cur = null;
        for(int k = 1;head != null;k++){
            Deque<ListNode> q = new ArrayDeque<>();
            for(int i = 0;i < k && head != null;i++){
                q.addLast(head);
                ListNode next = head.next;
                head.next = null;
                head = next;
            }
            if(q.size() % 2 == 1){
                while(!q.isEmpty()){
                    ListNode x = q.pollFirst();
                    if(cur != null)cur.next = x;
                    cur = x;
                }
            }else{
                while(!q.isEmpty()){
                    ListNode x = q.pollLast();
                    if(cur != null)cur.next = x;
                    cur = x;
                }
            }
        }
        return ret;
    }
}
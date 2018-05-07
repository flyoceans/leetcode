/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        while (root != null) {
            TreeLinkNode dummy = new TreeLinkNode(0);
            TreeLinkNode tmp = dummy;
            while (root != null) {
            if (root.left != null) {
                tmp.next = root.left;
                tmp = root.left;
            }
            if (root.right != null) {
                tmp.next = root.right;
                tmp = root.right;
            }
            
                root = root.next;
            }
            root = dummy.next;
        }
        
    }
}
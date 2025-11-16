/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode tmp=node,prev=null;;
        while(tmp.next!=null){
            prev=tmp;
            tmp.val=tmp.next.val;
            tmp=tmp.next;
        }
        prev.next=null;
        
    }
}
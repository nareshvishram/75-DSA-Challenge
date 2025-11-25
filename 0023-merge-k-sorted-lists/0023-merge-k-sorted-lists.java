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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode ans = null;
        ListNode dummy = new ListNode(-1);
        ans = dummy;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                pq.add(lists[i]);
        }
        while (!pq.isEmpty()) {
            ListNode l = pq.poll();
            dummy.next = new ListNode(l.val);
            dummy = dummy.next;
            if (l.next != null)
                pq.add(l.next);
        }
        return ans.next;
    }
}
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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        if (lists.length == 1)
            return lists[0];
        for (int i = 0; i < lists.length; i++)
            if (lists[i] != null)
                pq.add(lists[i]);
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            dummy.next = new ListNode(curr.val);
            dummy = dummy.next;
            curr = curr.next;
            if (curr != null)
                pq.add(curr);
        }
        return res.next;
    }
}
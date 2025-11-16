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
    ListNode root=null;
    ListNode curr=null;

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        while(list1!=null && list2!=null){
            if(list1.val>=list2.val){
                insert(list2);
                list2=list2.next;
            }else{
                insert(list1);
                list1=list1.next;
            }
        }
        while(list1!=null){
            insert(list1);
            list1=list1.next;
        }
        while(list2!=null){
            insert(list2);
            list2=list2.next;
        }
        return root;
    }
    private void insert(ListNode node){
        if(root==null){
            root=node;
            curr=root;
        }else{
            curr.next=node;
            curr=curr.next;
        }
    }
}
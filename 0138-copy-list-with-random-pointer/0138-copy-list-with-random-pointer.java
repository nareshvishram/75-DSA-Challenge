/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node ans = null;
        ans = insert(head);
        ans = link(head);
        return removeLink(head);
    }

    private Node insert(Node root) {
        Node ptr = root;
        while (ptr != null) {
            Node copy = new Node(ptr.val);
            Node next = ptr.next;
            ptr.next = copy;
            copy.next = next;
            ptr = next;
        }
        return root;
    }

    private Node link(Node root) {
        Node ptr = root;
        while (ptr != null) {
            if (ptr.random != null)
                ptr.next.random = ptr.random.next;
            else
                ptr.next.random = null;
            ptr = ptr.next.next;
        }
        return root;
    }

    private Node removeLink(Node root) {
        Node ptr = root;
        Node dummy = new Node(-1);
        Node res = dummy;
        while (ptr != null) {
            Node copy = ptr.next;
            ptr.next=copy.next;
            res.next=copy;
            res=res.next;
            ptr=ptr.next;
        }
        return dummy.next;
    }
}
package linkedlist;

public class leetcode160 {
    public static void main(String[] args) {
        
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
    }
    public int length(ListNode head){
        int length=0;
        ListNode temp=head;
        while (temp!=null) {
            length++;
            temp=temp.next;
        }
        return length;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { 
        this.val = val; 
    }
    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next;
    }
}

package linkedlist;

public class leetcode715 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length=length(head);
        int parts=length/k;
        int elements=length%k;
        int i=0;
        ListNode temp=head;
        ListNode[] ans= new ListNode[parts];
        while (i<parts && temp.next!=null ) {
            if(elements!=0){
                
            }
        }
        return ans;
    }
    public int length(ListNode head){
        int length=0;
        ListNode temp=head;
        while (temp.next!=null) {
            length++;
            temp=temp.next;
        }
        return length;
    }
}

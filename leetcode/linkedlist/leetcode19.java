package linkedlist;

public class leetcode19{
    public class ListNode {
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
    public static void main(String[] args) {
        
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length=length(head);
        if(n>length){
            return null;
        }
        int rem=length-n;
        for(int i=1;i<rem;i++){
            head=head.next;
        }
        head.next=head.next.next;
        return head;
    }
    public int length(ListNode head){
        int len=0;
        while(head.next!=null){
            head=head.next;
            len++;
        }
        return len;
    }
}
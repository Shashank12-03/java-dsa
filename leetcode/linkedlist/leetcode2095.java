package linkedlist;

public class leetcode2095 {
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
    public ListNode deleteMiddle(ListNode head) {
        ListNode midprev=middle(head);
        midprev.next=midprev.next.next;
        return head;
    }
    public ListNode middle(ListNode head){
        // int length=1;
        // ListNode temp=head;
        // while (temp!=null){
        //     length++;
        //     temp=temp.next;
        // }
        // ListNode middleprev=head;
        // for(int i=0;i<(length/2)-1;i++){
        //     middleprev=middleprev.next;
        // }
        // return middleprev;
        ListNode prev=head;
        ListNode f=head;
        ListNode s=head;
        while(f!=null && f.next!=null){
            f=f.next.next;
            prev=s;
            s=s.next;
        }
        return prev;
    }
}

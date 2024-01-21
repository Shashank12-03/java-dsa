package linkedlist;

public class leetcode62 {
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
    public ListNode rotateRight(ListNode head, int k) {
        if(k<=0 || head==null || head.next==null){
            return head;
        }
        int length=1;
        ListNode temp=head;
        while(temp.next!=null){
            length++;
            temp=temp.next;
        }
        temp.next=head;
        int rotation=k % length;
        int skip=length-rotation;
        ListNode move=head;
        for(int i=0;i<skip-1;i++){
            move=move.next;
        }
        head=move.next;
        move.next=null;
        return head;
    }
}

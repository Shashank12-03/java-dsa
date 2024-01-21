package linkedlist;

public class leetcode25 {
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
    
    public ListNode reverseKGroup(ListNode head, int k) {
        int length=length(head);
        if(head==null || k>length){
            return head;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode curr=dummy;
        while (curr!=null) {
            ListNode temp=curr;
            for(int i=0;i<k;i++){
                temp=temp.next;
                if(temp==null){
                    return dummy.next;
                }
            }
            ListNode nxt=temp.next;
            ListNode last=curr.next;
            temp.next=null;
            curr.next=reverse(curr);
            last.next=nxt;
            curr=last;
        }

        return dummy.next;
    }
    private ListNode reverse(ListNode head) {
        
        ListNode prev=null;
        ListNode pres=head;
        ListNode nex=null;
        while (pres!=null) {
            nex=pres.next;
            pres.next=prev;
            prev=pres;
            pres=nex;
        }
        return prev;
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

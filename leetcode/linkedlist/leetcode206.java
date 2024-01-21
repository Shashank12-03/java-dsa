package linkedlist;

public class leetcode206 {
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
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode prev=null;
        ListNode pres=head;
        ListNode nex=pres.next;
        while (pres!=null) {
            pres.next=prev;
            prev=pres;
            pres=nex;
            nex=nex.next;
        }
        head=prev;
        return head;
    }
}

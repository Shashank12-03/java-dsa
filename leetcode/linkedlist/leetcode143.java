package linkedlist;

public class leetcode143 {
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
    public void reorderList(ListNode head) {
        if(head==null){
            return;
        }
        ListNode hf=head;
        ListNode mid=getmid(head);
        ListNode hs=reverseList(mid);
        while(hf!=null && hs!=null){
            ListNode temp=hf.next;
            hf.next=hs;
            hf=temp;
            temp=hs.next;
            hs.next=hf;
            hs=temp;
        }
        if(hf!=null){
            hf.next=null;
        }
    }
    public ListNode getmid(ListNode head){
        // ListNode f=head;
        // ListNode s=head;
        // while(f!=null && f.next!=null){
        //     f=f.next.next;
        //     s=s.next;
        // }
        // return s;
        ListNode midpre=null;
        while(head!=null && head.next!=null){
            midpre=(midpre==null)?head:midpre.next;
            head=head.next.next;
        }
        ListNode mid=midpre.next;
        midpre.next=null;
        return mid;
    }
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode secondhead=new ListNode();
        secondhead=head;
        ListNode prev=null;
        ListNode pres=secondhead;
        ListNode nex=pres.next;
        while (pres!=null) {
            pres.next=prev;
            prev=pres;
            pres=nex;
            nex=nex.next;
        }
        secondhead=prev;
        return secondhead;
    }
}

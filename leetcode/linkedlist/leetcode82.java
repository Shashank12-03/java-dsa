package linkedlist;

public class leetcode82 {
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode Prevprev=null;
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            Prevprev =prev;
            prev=curr;
            int val= curr.val;
            int flag=0;
            while(curr.next!=null && curr.next.val==val){
                curr=curr.next;
                flag=1;
            }
            if(flag==1){
                if(Prevprev==null){
                    head=curr.next;
                    Prevprev=null;
                    prev=null;
                }else{
                    prev=Prevprev;
                    Prevprev.next=curr.next;
                }
            }
            curr=curr.next;
        }
        return head;
    }
}

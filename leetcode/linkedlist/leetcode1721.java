package linkedlist;
public class leetcode1721 {
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
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null){
            return null;
        }
        int length=1;
        ListNode temp=head;
        while(temp.next!=null){
            length++;
            temp=temp.next;
        }
        ListNode prev1=head;
        ListNode prev2=head;
        for(int i=1;prev1!=null &&i<k-1;i++){
            prev1=prev1.next;
        }
        ListNode node1=prev1.next;
        for(int i=0;prev2!=null && i<length-k;i++){
            prev2=prev2.next;
        }
        ListNode node2=prev2.next;
        ListNode temp1=node1.next;
        ListNode temp2=node2.next;
        prev2.next=node1;
        node1.next=temp2;
        prev1.next=node2;
        node2.next=temp1;
        return head;
    }
}

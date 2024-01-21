package linkedlist;

public class leetcode86 {
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
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return head;
        }
        ListNode node1= new ListNode();
        ListNode node2=new ListNode();
        ListNode temp=head;
        while (temp!=null) {
            if(temp.val<x){
                node1=temp;
                node1=node1.next;
            }
            else{
                node2=temp;
                node2=node2.next;
            }
            temp=temp.next;
        }
        node1.next=node2;
        return node1;
    }
}

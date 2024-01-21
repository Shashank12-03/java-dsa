package linkedlist;

public class leetcode328 {
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
    // public ListNode oddEvenList(ListNode head) {
    //     ListNode odd=head;
    //     ListNode even=head.next;
    //     while(odd!=null && even!=null){
    //         odd=odd.next.next;
    //         even=even.next.next;
    //     }
    //     odd.next=even.next;
    // }
}

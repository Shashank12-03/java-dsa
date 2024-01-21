package linkedlist;

public class leetcode148{
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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid=getmid(head);
        ListNode left=sortList(head);
        ListNode right=sortList(mid);
        return merge(left, right);
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
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dumyhead= new ListNode();
        ListNode temp= dumyhead;
        while(head1!=null && head2!=null){
            if(head1.val>head2.val){
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
            else{
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
        }
        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return dumyhead.next;
    }
}
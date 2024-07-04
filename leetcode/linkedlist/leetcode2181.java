package linkedlist;

public class leetcode2181 {
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
        //  head = [0,3,1,0,4,5,2,0]
        // [4,11]
    }
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        head = head.next; 
        int sum =0;
        while (head!=null) {
            if(head.val==0){
                temp.next = new ListNode(sum);
                // it = it.next;
                temp = temp.next;
                sum=0;
            }else{
                sum+=temp.val;
                
            }
            temp = temp.next;
            head = head.next;
        }
        return dummy.next;
    }
}

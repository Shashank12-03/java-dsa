package linkedlist;

public class leetcode715 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        // head.next.next.next.next.next = new ListNode(6);
        // head.next.next.next.next.next.next = new ListNode(7);
        // head.next.next.next.next.next.next.next = new ListNode(8);
        // head.next.next.next.next.next.next.next.next = new ListNode(9);
        // head.next.next.next.next.next.next.next.next.next = new ListNode(10);
        // head.next = new ListNode(1);
        ListNode[] arr = splitListToParts(head, 3);
        System.out.println(arr);
    }
    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode [] result = new ListNode[k];
        int length = 0;
        ListNode cur = head;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        int eachSplitNode = length/k;
        int extraNode = length%k;
        cur = head;
        ListNode prev = null;
        for(int i = 0; cur != null && i < k ; i++) {
            result[i] = cur;
            for(int count = 1; count <= eachSplitNode + (extraNode > 0 ? 1 : 0); count++) {
                prev = cur;
                cur = cur.next;
            }
            prev.next = null;
            extraNode--;
        }
        return result;

        // int length=length(head);
        // int mod=length%k;
        // int size = length/k;
        // ListNode[] ans= new ListNode[k];
        // for (int j = 0; j < ans.length; j++) {
        //     ListNode dummy = new ListNode(-1);
        //     ListNode temp=dummy;
        //     if (length<=k){
        //         if(mod>=0 && head!=null){
        //             temp.next = head;
        //             temp = temp.next;
        //             head = head.next;
        //         }
        //     }
        //     else{
        //         int i=0;
        //         int limit = 0;
        //         if (mod>=0){
        //             limit = size+1;
        //         }
        //         else{
        //             limit = size;
        //         }
        //         while (i<limit && head!=null) {
        //             System.out.println(temp.val);
        //             temp.next = head;
        //             temp = temp.next;
        //             System.out.println(temp.val);
        //             head = head.next;
        //             i++;
        //         }
        //     }
        //     temp.next = null;
        //     if(mod>0){
        //         mod--;
        //     }
        //     ans[j] = dummy.next;
        // }
        // return ans;
    }
    // public static int length(ListNode head){
    //     int length=0;
    //     ListNode temp=head;
    //     while (temp!=null) {
    //         length++;
    //         temp=temp.next;
    //     }
    //     return length;
    // }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
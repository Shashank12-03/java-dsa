package linkedlist;

public class leetcode1669 {
    public static void main(String[] args) {
        
    }
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp=list1;
        ListNode start=list1;
        ListNode end=list1;
        while (a>1 ||b>=0) {
            if (a==1) {
                start=temp;
            }
            if (b==0) {
                end=temp;
            }
            temp=temp.next;
            a--;
            b--;
        }
        ListNode list2End=list2;
        while (list2End.next!=null) {
            list2End=list2End.next;
        }
        start.next=list2;
        list2End.next=end.next;
        return list1;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
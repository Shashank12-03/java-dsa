package linkedlist;


public class leetcode2130 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        leetcode2130 solution = new leetcode2130();
        int result = solution.pairSum(head);
        System.out.println("The maximum twin sum is: " + result);
    }
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prev = null;
        ListNode curr = slow;
        ListNode nex = null;
        while(curr!=null){
            nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }
        ListNode temp = prev;
        int maxTwin = 0;
        while(temp!=null){
            maxTwin = Math.max(maxTwin,temp.val + head.val);
            temp = temp.next;
            head = head.next;
        }
        return maxTwin;
    }
}

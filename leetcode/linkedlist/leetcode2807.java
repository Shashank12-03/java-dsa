package linkedlist;

public class leetcode2807 {

    public static void main(String[] args) {
        ListNode head = new ListNode(18);
        head.next = new ListNode(6);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(3);
        leetcode2807 sol = new leetcode2807();
        ListNode ans = sol.insertGreatestCommonDivisors(head);
        System.out.println(ans);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        
        while (head != null && head.next != null) {
            ListNode first = head;
            System.out.println(first.val);
            ListNode second = head.next;
            System.out.println(temp.val);
            temp.next = first;
            temp = temp.next;
            int gcd = findGCD(first.val,second.val);
            ListNode Gcd = new ListNode(gcd);
            System.out.println(temp.val);
            temp.next = Gcd;
            temp = temp.next;
            temp.next = second;
            temp = temp.next;
            System.out.println(temp.val);
            head = head.next.next;
            System.out.println(head.val);
        }
        temp.next = null;
        return dummy.next;
    }

    private int findGCD(int val1, int val2) {
        if (val2 == 0) {
            return val1;
        }
        return findGCD(val2, val1 % val2);
    }
}

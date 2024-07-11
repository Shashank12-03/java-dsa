package linkedlist;


public class leetcode2058 {

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

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }
        
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode nxt = head.next.next;
        
        int first = -1;
        int last = -1;
        int min = Integer.MAX_VALUE;
        
        int count = 1;
        while (nxt != null) {
            if ((prev.val < curr.val && nxt.val < curr.val) || (prev.val > curr.val && nxt.val > curr.val)) {
                if (first == -1) {
                    first = count;
                } else {
                    min = Math.min(min, count - last);
                }
                last = count;
            }
            prev = curr;
            curr = nxt;
            nxt = nxt.next;
            count++;
        }
        
        if (first == last) {
            return new int[]{-1, -1};
        }
        
        return new int[]{min == Integer.MAX_VALUE ? -1 : min, last - first};        
    }
}


package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class leetcode3217 {
    public static void main(String[] args) {
        
    }
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ListNode temp = null;
        while (head!=null) {
            if(set.contains(head.val) && head.next!=null){
                temp = head;
                head = head.next;
                temp = null;
            }
            else{
                head = head.next;
            }
        }
        return head;
    }
}

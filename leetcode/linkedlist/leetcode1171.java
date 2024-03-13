package linkedlist;
import linkedlist.leetcode19.ListNode;
import java.util.*;

public class leetcode1171 {
    public static void main(String[] args) {
        
    }
    public static ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        HashMap<Integer,ListNode> map=new HashMap<>();
        int sum=0;
        for(ListNode temp=dummy;temp!=null;temp=temp.next){
            sum+=temp.val;
            if (map.containsKey(sum)) {
                ListNode prev=map.get(sum);
                ListNode toRemove=prev.next;
                int value=sum+(toRemove!=null ?toRemove.val:0);
                while (value!=sum) {
                    map.remove(value);
                    toRemove=toRemove.next;
                    value+=(toRemove!=null ?toRemove.val:0);
                }
                prev.next=temp.next;
            }else{
                map.put(sum, temp);
            }
        }
        return dummy.next;
    }

}

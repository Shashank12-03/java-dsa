package linkedlist;
import java.util.*;
public class leetccode234 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(isPalindrome(head));

    }
    public static boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }
        List <Character> str = new ArrayList<>(); 
        ListNode temp = head;
        while (temp!=null) {
            str.add((char)temp.val);
            temp=temp.next;
        }
        for(int i=0;i<str.size();i++){
            if(str.get(i)!= str.get(str.size()-i-1)){
                return false;
            }
        }
        return true;
    }
}
class ListNode {
    int  val;
    ListNode next;
    ListNode() {}
    ListNode(int  val) { 
        this.val = val; 
    }
    ListNode(int  val, ListNode next) { 
        this.val = val; 
        this.next = next;
    }
}

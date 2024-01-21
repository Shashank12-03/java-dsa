package linkedlist;

public class leetcode2 {
    public class ListNode {
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
    public static void main(String[] args) {
        
    }
    // public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    //     int  first=listtonum(l1);
    //     int  second=listtonum(l2);
    //     int  third=first+second;
    //     int  ans=0;
    //     while (third>0) {
    //         int  num=third%10;
    //         ans+=(ans*10)+num;
    //         third=third/10;
    //     }
    //     return inttolist(ans);
    // }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int first = listtonum(l1);
        int second = listtonum(l2);
        int third = first + second;
        int ans = 0;
        while (third > 0) {
            int num = third % 10;
            ans = (ans * 10) + num; // Corrected line
            third = third / 10;
        }
        return inttolist(ans);
    }
    
    // public int  listtonum(ListNode head){
    //     int  num=0;
    //     while (length(head)!=0) {
    //         num+=(num*10) + head.val;
    //         head=head.next;
    //     }
    //     return num;
    // }
    public int listtonum(ListNode head){
        int num = 0;
        while (head != null) {
            num = (num * 10) + head.val;
            head = head.next;
        }
        return num;
    }
    
    public int length(ListNode head){
        int  length=1;
        ListNode temp=head;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        return length;
    }
    // public ListNode inttolist(int  num){
    //     ListNode dummy= new ListNode();
    //     ListNode temp=dummy;
    //     while(num>0){
    //         int  number=num%10;
    //         temp.val=number;
    //         temp=temp.next;
    //     }
    //     return dummy;
    // }
    public ListNode inttolist(int num){
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while (num > 0){
            int number = num % 10;
            num = num / 10;  // Update num
            temp.next = new ListNode(number);
            temp = temp.next;
        }
        return dummy.next;
    }
    
}

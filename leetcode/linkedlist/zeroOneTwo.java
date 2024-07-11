package linkedlist;

public class zeroOneTwo {
    class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
    public static void main(String[] args) {
        
    }
    public static Node segregate(Node head) {
        // add your code here
        int zero = 0;
        int one = 0;
        int two = 0;
        Node temp = head;
        while (temp!=null) {
            if (temp.data==0){
                zero++;
            }
            if (temp.data==1){
                one++;
            }
            if (temp.data==2){
                two++;
            }
            temp = temp.next;
        }
        while (zero!=0) {
            head.data = 0;
            head = head.next;
            zero--;
        }
        while (one!=0) {
            head.data = 1;
            head = head.next;
            one--;
        }
        while (two!=0) {
            head.data = 2;
            head = head.next;
            two--;
        }
        return head;
    }
}

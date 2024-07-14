package linkedlist;

public class addOne {
    
    public static void main(String[] args) {
        Node node = new Node(9);
        node.next = new Node(9);
        node.next.next = new Node(9);
        Node ans =  addone(node);
        printList(ans);
    }
    public static Node addone(Node head) 
    { 
        //code here.
        head = reverse(head);
        Node temp = head;
        while (temp!=null) {
            if (temp.next==null && temp.data==9) {
                temp.data =0;
                Node extra = new Node(1);
                temp.next = extra;
                temp = temp.next;
                break;
            }
            else if (temp.data==9){
                temp.data = 0;
                temp = temp.next;
            }
            else{
                temp.data = temp.data+1;
                temp = temp.next;
                break;
            }
        }
        head = reverse(head);
        return head;
    }
    private static Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr!=null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    } 
    public static void printList(Node head) {
        while(head.next != null) {
        System.out.print(head.data+"->");
            head = head.next;
        }
        System.out.println(head.data);
    }
}
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

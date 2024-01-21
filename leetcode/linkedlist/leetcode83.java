package linkedlist;
//remove duplicates
public class leetcode83 {
    private Node head;
    private Node tail;
    int size;
    public leetcode83(){
        this.size=0;
    }
    private class Node{
        private int value;
        private Node next;
        public Node(int value){
            this.value=value;
        }
        // public Node(int value,Node next){
        //     this.value=value;
        //     this.next=next;
        // }
    }
    public void insertfirst(int value){
        Node node=new Node(value);
        node.next=head;
        head=node;
        if(tail==null){
            tail=head;
        }
        size+=1;
    }
    public void insertlast(int value){
        if(size==0){
            insertfirst(value);
        }
        else{
            Node node=new Node(value);
            tail.next=node;
            tail=node;
        }
    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+"->");
            temp=temp.next;
        }
        System.out.print("End");
    }
    public static void main(String[] args) {
        leetcode83 list= new leetcode83();
        list.insertlast(10);
        list.insertlast(10);
        list.insertlast(20);
        list.insertlast(30);
        list.insertlast(30); 
        list.display();
        list.removeduplicates();
        System.out.println();
        list.display();
    }
    // public void removeduplicates(){
    //     Node node=head;
    //     while(node.next!=null){
    //         if(node.value==node.next.value){
    //             node.next=node.next.next;
    //             size--;
    //         }
    //         else{
    //             node=node.next;
    //         }
    //     }
    //     tail=node;
    //     tail.next=null;
    // }
     public Node removeduplicates(){
        if(head==null){
            return head;
        }
        Node node=head;
        while(node.next!=null){
            if(node.value==node.next.value){
                node.next=node.next.next;
            }
            else{
                node=node.next;
            }
        }
        return node;
    }
}

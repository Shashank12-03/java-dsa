package dsa.linkedlist;

public class doublyLL {
    private Node head;
    private Node tail;
    int size;
    public doublyLL(){
        this.size=0;
    }
    private class Node{
        private int value;
        private Node next;
        private Node prev;
        public Node(int value){
            this.value=value;
        }
        public Node(int value,Node next,Node prev){
            this.value=value;
            this.next=next;
            this.prev=prev;
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
    public void insertstart(int value){
        Node node=new Node(value);
        if(head==null){
            head=node;
            tail=node;
        }
        else{
            node.next=head;
            head.prev=node;
            head=node;
        }
        size+=1;
    }
    public void insertend(int value){
        Node node=new Node(value);
        if(size==0){
            insertstart(value);
        }
        else{
            tail.next=node;
            node.prev=tail;
            tail=node; 
        }
        size+=1;
    }
    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
    public void insert(int after, int val) {
        Node p = find(after);

        if (p == null) {
            System.out.println("does not exist");
            return;
        }

        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if (node.next != null) {
            node.next.prev = node;
        }
    }
    public int deletestart(){
        int val=head.value;
        head=head.next;
        if(head==null){
            tail=null;
        }
        return val;
    }
    public int deleteend(){
        if(size<2){
            return deletestart();
        }
        int val=tail.value;
        tail=tail.prev;
        tail.next=null;
        return val;
    }
}

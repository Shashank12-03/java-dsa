package dsa.linkedlist;

public class singlyLL {
    private Node head;
    private Node tail;
    int size;
    public singlyLL(){
        this.size=0;
    }
    private class Node{
        private int value;
        private Node next;
        public Node(int value){
            this.value=value;
        }
        public Node(int value,Node next){
            this.value=value;
            this.next=next;
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
    public void insert(int value,int index){
        if(index==0){
            insertfirst(value);
        }
        if(index==size){
            insertlast(value);
        }
        Node temp=head;
        for(int i=1;i<index;i++){
            temp=temp.next;
        }
        Node node=new Node(value, temp.next);
        temp.next=node;
        size++;
    }
    public int deletefirst(){
        int val=head.value;
        head=head.next;
        if(head==null){
            tail=null;
        }
        size--;
        return val;
    }
    public Node get(int index){
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }
    public int deletelast(){
        if(size<=1){
            return deletefirst();
        }
        Node secondlast=get(size-2);

        int val=tail.value;
        tail=secondlast;
        tail.next=null;
        size--;
        return val;
    }
    public int delete(int index){
        if(index==0){
            return deletefirst();
        }
        if(index==size-1){
            return deletelast();
        }
        else{
            Node prev=get(index-1);
            int val=prev.next.value;
            prev.next=prev.next.next;
            size--;
            return val;
        }
    }
}

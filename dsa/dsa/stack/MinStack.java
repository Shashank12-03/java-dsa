package dsa.stack;
class MinStack {
    public class Node{
        int min;
        int val;
        Node prev;
        Node next;
        public Node(int min,int val,Node prev,Node next){
            this.min=min;
            this.val=val;
            this.prev=prev;
            this.next=next;
        }
    }
    private Node head;
    public MinStack(){
        this.head=new Node(Integer.MAX_VALUE,0,null,null);
    }
    
    public void push(int val) {
        // if(this.isfull()){
        //     int[] temp=new int[data.length*2];
        //     for(int i=0;i<data.length;i++){
        //         temp[i]=data[i];
        //     }
        //     data=temp;
        // }
        Node nextNode;
        if (val<=head.min) {
            nextNode=new Node(val, val, head, null);
        }
        else{
            nextNode=new Node(head.min, val, head, null);
        }
        head.next=nextNode;
        head=nextNode;
    }
    public void pop() {
        head=head.prev;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}
package dsa.queue;

public class queuemain {
    public static void main(String[] args) throws Exception {
        customqueue queue= new customqueue(6);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        System.out.println(queue.front());
    }
}

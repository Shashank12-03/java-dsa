import java.util.Queue;
import java.util.LinkedList;;
 
class MyStack {
    Queue<Integer> queue;
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.offer(x);
        int k =0;
        while(k<queue.size()-1){
            queue.offer(queue.poll());
            k++;
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
       return queue.peek(); 
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

package dsa.queue;

import java.util.Arrays;

class MyCircularDeque {
    int[] data;
    int front;
    int rear;
    int size;
    public MyCircularDeque(int k) {
        size = k;
        data = new int[k];
        Arrays.fill(data,-1);
        front = k;
        rear = -1;
    }
    
    public boolean insertFront(int value) {
        System.out.println(Arrays.toString(data));
        front--;
        if (front>rear) {
            data[front] = value;
            return true;
        }
        return false;
    }
    
    public boolean insertLast(int value) {
        System.out.println(Arrays.toString(data));
        rear++;
        if (rear<front) {
            data[rear] = value;
            return true;
        }
        return false;
    }
    
    public boolean deleteFront() {
        System.out.println(Arrays.toString(data));
        if (data[front]==-1) {
            return false;
        }
        data[front] = -1;
        front++;
        return true;
    }
    
    public boolean deleteLast() {
        System.out.println(Arrays.toString(data));
        if (data[rear]==-1) {
            return false;
        }
        data[rear] = -1;
        rear--;
        return true;
    }
    
    public int getFront() {
        System.out.println(Arrays.toString(data));
        return data[front];
    }
    
    public int getRear() {
        System.out.println(Arrays.toString(data));
        return data[rear];
    }
    
    public boolean isEmpty() {
        System.out.println(Arrays.toString(data));
        if (rear==0 && front==size-1) {
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        System.out.println(Arrays.toString(data));
        if (front==rear) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        myCircularDeque.insertLast(1);  // return True
        myCircularDeque.insertLast(2);  // return True
        myCircularDeque.insertFront(3); // return True
        myCircularDeque.insertFront(4); // return False, the queue is full.
        myCircularDeque.getRear();      // return 2
        myCircularDeque.isFull();       // return True
        myCircularDeque.deleteLast();   // return True
        myCircularDeque.insertFront(4); // return True
        myCircularDeque.getFront();     // return 4
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
package stack;

import java.util.Stack;

//leetcode1981
public class CustomStack {
     
    protected int[] data;
    //static final int DEFAULT_SIZE=10;
    int ptr=-1;
    // public CustomStack(){
    //     this(DEFAULT_SIZE);
    // }
    public CustomStack(int size){
        this.data=new int[size];
    }
    public void push(int item){
        if(isfull()){
            return;
        }
        else{
            ptr++;
            data[ptr]=item;
        }
    }
    public boolean isfull(){
        return ptr==data.length-1;
    }
    public boolean isempty(){
        return ptr==-1;
    }
    public int pop(){
        if(isempty()){
            return -1;
        }
        else{
            int removed= data[ptr];
            ptr--;
            return removed;        
        }
    }
    public void increment(int k, int val) {
        Stack<Integer> stk = new Stack<>();
        int n = data.length;
        int i = n-1;
    
        // Push elements from the 'data' array into 'stk'
        while (i >=0) {
            stk.push(data[i]);
            i--;
        }
    
        i = 0;
        int j = -1;
    
        // Increment the top 'k' elements from 'stk'
        while (!stk.isEmpty() && i < k) {
            j++;
            data[j] = stk.pop() + val;
            i++;
        }
    }
} 

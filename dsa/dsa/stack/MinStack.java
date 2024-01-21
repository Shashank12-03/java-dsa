package dsa.stack;
class MinStack {
    int[] data;
    int ptr=-1;
    static final int DEFAULT_SIZE=10;
    public MinStack(){
        this(DEFAULT_SIZE);
    }
    public MinStack(int size){
        this.data=new int[size];
    }
    
    public void push(int val) {
        // if(this.isfull()){
        //     int[] temp=new int[data.length*2];
        //     for(int i=0;i<data.length;i++){
        //         temp[i]=data[i];
        //     }
        //     data=temp;
        // }
        ptr++;
        data[ptr]=val;
    }
    public boolean isfull(){
        return ptr==data.length-1;
    }
    public void pop() {
        ptr--;
    }
    
    public int top() {
        return data[ptr];
    }
    
    public int getMin() {
        int[] temp=new int[data.length];
        for(int i=0;i<=ptr;i++){
            temp[i]=data[i];
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=ptr;i++){
            min=Math.min(min,temp[i]);
        }
        return min;
    }
}
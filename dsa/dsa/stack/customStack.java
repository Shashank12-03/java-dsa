package dsa.stack;

public class customStack {
    protected int[] data;
    static final int DEFAULT_SIZE=10;
    int ptr=-1;
    public customStack(){
        this(DEFAULT_SIZE);
    }
    public customStack(int size){
        this.data=new int[size];
    }
    public boolean push(int item){
        if(isfull()){
            return false;
        }
        else{
            ptr++;
            data[ptr]=item;
            return true;
        }
    }
    public boolean isfull(){
        return ptr==data.length-1;
    }
    public boolean isempty(){
        return ptr==-1;
    }
    public int pop() throws Stackexception{
        if(isempty()){
            throw new Stackexception("Cannot pop from an empty stack");
        }
        else{
            int removed= data[ptr];
            ptr--;
            return removed;        }
    }
    public int peak() throws Stackexception{
         if(isempty()){
            throw new Stackexception("Cannot peak from an empty stack");
        }
        else{
            return data[ptr];
        }
    }
}

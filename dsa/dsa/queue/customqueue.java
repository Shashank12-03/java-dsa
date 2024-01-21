package dsa.queue;

public class customqueue {
    private int[] data;
    private static final int DEFAULT_SIZE=10;
    int end=0;
    public customqueue(){
        this(DEFAULT_SIZE);
    }
    public customqueue(int size){
        this.data=new int[size];
    }
    public boolean isfull(){
        return end==data.length;
    }
    public boolean isempty(){
        return end==0;
    }
    public boolean insert(int item){
        if(isfull()){
            return false;
        }
        else{
            data[end++]=item;
            return true;
        }
    }
    public int deque() throws Exception{
        if(isempty()){
            throw new Exception("Queue is empty");
        }
        int removed =data[0];
        for(int i=1;i<end;i++){
            data[i-1]=data[i];
        }
        end--;
        return removed;
    }
    public int front() throws Exception{
        if(isempty()){
            throw new Exception("Queue is empty");
        }
        return data[0];
    }
}

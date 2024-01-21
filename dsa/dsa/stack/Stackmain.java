package dsa.stack;

public class Stackmain {
    public static void main(String[] args) {
        //customStack stack= new dynamicstack(5);
        MinStack stack= new MinStack();
        stack.push(2);
        stack.push(0);
        stack.push(3);
        stack.push(0);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}

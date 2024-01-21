
import java.util.Arrays;
import java.util.Stack;
public class leetcode739 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] temp=new int[n];
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                int x=st.peek();
                temp[x]=i-x;
                st.pop();
            }
            st.push(i);
        }
        return temp;
    }
}

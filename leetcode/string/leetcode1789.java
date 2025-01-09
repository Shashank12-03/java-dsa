package string;

public class leetcode1789 {

    public static void main(String[] args) {
        
    }
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int forward = 0;
        int backward = 0;
        int[] ans = new int[n];
        int ones = boxes.charAt(0)=='1'?1:0;
        for(int i = 1;i<n;i++){
            forward= ones + forward;
            if(boxes.charAt(i)=='1'){
                ones++;
            }
            ans[i] = forward;
        }
        ones = boxes.charAt(n-1)=='1'?1:0;
        for(int i = n-2;i>=0;i--){
            backward = ones + backward;
            if(boxes.charAt(i)=='1'){
                ones++;
            }
            ans[i] += backward;
        }
        return ans;
    }
}
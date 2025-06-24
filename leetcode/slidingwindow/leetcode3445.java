package slidingwindow;

import java.util.Arrays;

public class leetcode3445 {
    public static void main(String[] args) {
        leetcode3445 obj = new leetcode3445();
        System.out.println(obj.maxDifference("110", 3));
    }
    public int maxDifference(String s, int k) {
        int n = s.length();
        int[][] freq = new int[n][5];
        freq[0][s.charAt(0)-'0']++;
        int maxOdd = 0;
        int minEven = Integer.MAX_VALUE;
        for(int i = 1;i<n;i++){
            int odd = 0;
            int even = Integer.MAX_VALUE;
            int ch = s.charAt(i)-'0';
            for(int j = 0;j<5;j++){
                if(ch==j){
                    freq[i][j] = freq[i-1][j]+1;
                }
                else{
                    freq[i][j] = freq[i-1][j];
                }
                
            }
            for(int j = 0;j<5;j++){
                if(freq[i][j]%2==1){
                    odd = Math.max(odd,freq[i][j]);
                }
                else if (freq[i][j]>0 && freq[i][j]%2==0){
                    even = Math.min(even,freq[i][j]);
                }
            }
            if(i>=k-1){
                maxOdd = Math.max(odd,maxOdd);
                minEven = Math.min(even,minEven);
            }
        }
        for(int[] is:freq){
            System.out.println(Arrays.toString(is));
        }
        return maxOdd-minEven;
    }
}

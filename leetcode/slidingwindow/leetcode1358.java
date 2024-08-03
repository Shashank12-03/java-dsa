package slidingwindow;

import java.util.Arrays;

public class leetcode1358 {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
    }
    public static int numberOfSubstrings(String s) {
        int count=0;
        // int i=0;
        int j=0;
        int[] arr=new int[3];
        Arrays.fill(arr,-1);
        while(j<s.length()){
            arr[s.charAt(j)-'a']=j;
            if(arr[0]!=-1 && arr[1]!=-1 && arr[2]!=-1){
                count+=Math.min(arr[0],Math.min(arr[1],arr[2]))+1;
            }
            j++;
        }
        return count;
    }
}

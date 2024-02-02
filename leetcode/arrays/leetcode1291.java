package arrays;
import java.util.*;
public class leetcode1291 {
    public static void main(String[] args) {
        System.out.println(sequentialDigits(100, 300));
    }
    public static List<Integer> sequentialDigits(int low, int high) {
        int[]seq={12, 23, 34, 45, 56, 67, 78, 89, 123, 234, 345, 456, 567, 678, 789, 1234, 2345, 3456, 4567, 5678, 6789, 12345, 23456, 34567, 45678, 56789, 123456, 234567, 345678, 456789, 1234567, 2345678, 3456789, 12345678, 23456789, 123456789};
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<seq.length;i++){
            if(seq[i]>=low && seq[i]<=high){
                ans.add(seq[i]);
            }
        }
        return ans;

    }
}

package string;
import java.math.BigInteger;

public class leetcode43 {
    public static void main(String[] args) {
        System.out.println(multiply("840477629533", "498828660196"));
    }
    public static String multiply(String num1, String num2) {
        BigInteger nums1=new BigInteger(num1);
        BigInteger nums2=new BigInteger(num2);
        BigInteger pro=nums1.multiply(nums2);
        String string = pro.toString();
        return string;
    }
    // public static long converttoint(String nums){
    //     long num=0;
    //     StringBuilder str= new StringBuilder(nums);
    //     while(!str.isEmpty()){
    //         int n=str.charAt(0);
    //         n= n-'0';
    //         num=num*10 +n;
    //         str.substring(1);
    //     }
    //     return num;
    // } 
}

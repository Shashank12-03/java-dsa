package sorting;
import java.util.*;
public class leetcode1342 {
    public static void main(String[] args) {
        Scanner t=new Scanner(System.in);
        int n=t.nextInt();
        System.out.println(numberOfSteps(n));
        t.close();
    }
    static int numberOfSteps(int num) {
        // int c=0;
        // while(num!=0){
        //     if(num%2!=0){
        //         num-=1;
        //         c++;
        //     }
        //     else{
        //         num=num/2;
        //         c++;
        //     }
        // }
        // return c;
        int c=0;
        return helper(num,c);
    }
    static int helper(int n, int c){
        if(n==0){
            return c;
        }
        if(n%2!=0){
            return helper(n-1,c+1);
        }
        else{
            return helper(n/2, c+1);
        }
        // if(n==0){
        //     return c;
        // }
    }
}

package sorting;
import java.util.*;

public class leetcode344 {
    public static void main(String[] args) {
        Scanner t=new Scanner(System.in);
        char[] arr=t.next().toCharArray();
        // reverseString(arr);
        // int n=t.nextInt();
        // Character[] arr=new Character[n];
        // for(int i=0;i<n;i++)
        // {
        //     arr[i]=t.next();
        // }
        reverseString(arr);
        t.close();
    }
    static void reverseString(char[] chars) {
        int s=0;
        int e=chars.length-1;
        if(chars.length==1){
            return;
        }
        while(s<=e){
            char temp=chars[s];
            chars[s]=chars[e];
            chars[e]=temp; 
            s++;
            e--;
        }
        System.out.println(Arrays.toString(chars));
    }
    // static void swap(char[] chars, int start,int end){
    //     if(chars.length==1){
    //         return;
    //     }
    //     if(start<=end){
    //         char temp=chars[start];
    //         chars[start]=chars[end];
    //         chars[end]=temp;
    //         swap(chars, start+1,end-1);  
    //     }
    // }
}

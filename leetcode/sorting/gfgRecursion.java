package sorting;
import java.util.*;
public class gfgRecursion {
    public static void main(String[] args) {
        Scanner t=new Scanner(System.in);
        int n=t.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=t.nextInt();
        }
        repeat(arr);
        t.close();
    }
    static void repeat (int[] arr){
        if(arr.length<1){
            return;
        }
        else{
            int[]temp=new int[arr.length-1];
            for(int i=0;i<arr.length-1;i++){
                temp[i]=arr[i]+arr[i+1];
            }
            //at each call the array size decreases by 1 by passing the temporary array(temp)  
            repeat(temp);
            System.out.println(Arrays.toString(arr));
        }
    }
}

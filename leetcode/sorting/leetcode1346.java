package sorting;
import java.util.*;
public class leetcode1346 {
    public static void main(String[] args) {
        Scanner t=new Scanner(System.in);
        // int n=t.nextInt();
        int[] arr={10,2,5,1};
        // for(int i=0;i<n;i++)
        // {
        //     arr[i]=t.nextInt();
        // }
        System.out.println(checkIfExist(arr));
        t.close();
    }
    static boolean checkIfExist(int[] arr) {
        for (int i=0 ; i<arr.length ; i++){
            for(int j=0 ; j<arr.length ; j++){
                if(i!=j){
                    if(arr[i] == 2 * arr[j])
                    {
                        return true;
                    }
                }
            }
        }  
        return false;  
    }
}


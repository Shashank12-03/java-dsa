package sorting;
import java.util.*;
public class leetcode448 {
    public static void main(String[] args) {
        Scanner t=new Scanner(System.in);
        int n=t.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=t.nextInt();
        }
        System.out.println(findDisappearedNumbers(arr));
        t.close();
    }
    public static List<Integer> findDisappearedNumbers(int[] arr) {
        int i=0;
        while(i<arr.length)
        {
            int correct=arr[i]-1;
            if(arr[correct]!=arr[i])
            {
                swap(arr,i,correct);
            }
            else
            {
                i++;
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(i=0; i<arr.length;i++)
        {
            if(arr[i]!=i+1)
            {
                ans.add(i+1);
            }
        }
        return ans;
    }
    
    static void swap(int[] arr,int i,int correct)
    {
        int temp=arr[i];
        arr[i]=arr[correct];
        arr[correct]=temp;
    }
}

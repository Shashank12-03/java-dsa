import java.util.*;
public class cyclesort {
    public static void main(String[] args) {
        
        Scanner t=new Scanner(System.in);
        int n=t.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=t.nextInt();
        }
        cs(arr);
        for(int i=0;i<n;i++)
        {
            System.out.println(arr[i]);
        }
        t.close();
    }
    static void cs(int[] arr)
    {
        int i=0;
        while(i<arr.length)
        {
            int correct=arr[i];
            if(arr[i]<arr.length && arr[correct]!=arr[i])
            {
                swap(arr,i,correct);
            }
            else
            {
                i++;
            }
        }
    }
    static void swap(int[] arr,int i,int correct)
    {
        int temp=arr[i];
        arr[i]=arr[correct];
        arr[correct]=temp;
    }
}
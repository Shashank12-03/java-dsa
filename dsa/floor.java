import java.util.*; 
public class floor {
    public static void main(String[] args) 
    {
        Scanner t=new Scanner(System.in);
        int n=t.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=t.nextInt();
        }
        int target=t.nextInt();
        int ans=flr(arr,target);
        System.out.println(ans);
        t.close();
    }
    static int flr(int[] arr,int target)
    {
        int l=0;
        int e=arr.length-1;
        while(l<=e)
        {
            int mid=l+(e-l)/2;
            if(arr[mid]==target)
            {
                return mid;
            }
           
            if(target<arr[mid])
            {
                e=mid-1;
            }
            else if(target>arr[mid])
            {
                l=mid+1;
            }
        }
        return arr[e];
    }
}



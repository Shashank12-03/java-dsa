import java.util.*; 
class BinarySearch
{
    public static void main(String[] args) 
    {
        Scanner t=new Scanner(System.in);
        int n=t.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=t.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]);
        }
        System.out.println();
        int target=t.nextInt();
        int ans=bs(arr,target);
        System.out.println(ans);
        t.close();
    }
    static int bs(int[] arr,int target)
    {
        int l=0;
        int e=arr.length-1;
        boolean isAsc=arr[l]<arr[e];
        while(l<=e)
        {
            int mid=l+(e-l)/2;
            if(target<arr[0])
            {
                return 0;
            }  
            if(arr[mid]==target)
            {
                return mid;
            }
            if(isAsc)
            {
                if(target<arr[mid])
                {
                    e=mid-1;
                }
                else if(target>arr[mid])
                {
                    l=mid+1;
                }
            }
            else
            {
                if(target>arr[mid])
                {
                    e=mid-1;
                }
                else if(target<arr[mid])
                {
                    l=mid+1;
                } 
            }
            return mid;      
        }
        return l+1;
    }   
}
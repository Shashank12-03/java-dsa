import java.util.*;
public class mergersort {
    public static void main(String[] args) {
        Scanner t=new Scanner(System.in);
        int n=t.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=t.nextInt();
        }
        System.out.println(Arrays.toString(Mergesort(arr)));
        t.close();
    }
    static int[] Mergesort(int[] arr){
        if(arr.length==1){
            return arr;
        }
        int mid=arr.length/2;
        int[] left=Mergesort(Arrays.copyOfRange(arr,0, mid));
        int[] right=Mergesort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left,right);
    }
    static int[] merge(int[] first,int[] second){
        int i=0;
        int j=0;
        int k=0;
        int[]temp=new int[first.length+second.length];
        while(i<first.length && j<second.length){
            if(first[i]<second[j]){
                temp[k++]=first[i];
                i++;
            }
            else{
                temp[k++]=second[j];
                j++;
            }
        }
        while(i<first.length){
            temp[k++]=first[i];
            i++;
        }
        while(j<second.length){
            temp[k++]=second[j];
            j++;
        }
        return temp;
    }
}

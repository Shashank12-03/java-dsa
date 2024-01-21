package sorting;
import java.util.Arrays;

public class gfgsorting {
    public static void main(String[] args) {
        int[] arr={2,13};
        int n=arr.length;
        System.out.println(majorityElement(arr,n));
    }
    static int majorityElement(int a[], int size)
    {
        // your code here
        Arrays.sort(a);
         if(size==2){
            if(a[size/2]==a[(size/2)-1]){
                return a[0];
            }
        }
        if(size==1){
            return a[size/2];
        }
        if(size>2 && (a[size/2]==a[(size/2)-1] || a[size/2]==a[(size/2)+1])){
            if(a[size/2]==a[0] || a[size/2]==a[size-1]){
                return a[size/2];
            }
        }
        return -1;
    }
}

package sorting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode18 {
    public static void main(String[] args) {
        int[] arr = {-1,0,-5,-2,-2,-4,0,1,-2};
        List<List<Integer>> ans= foursum(arr,-9);
        for(List<Integer> list:ans){
            System.out.println(list);
        }
    }
    public static List<List<Integer>> foursum(int[] arr, int target){
        List<List<Integer>> ans = new ArrayList<>();
        int n=arr.length;
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            if(i>0 && arr[i]==arr[i-1]){
                continue;
            }
            for(int j=i+1;j<n;j++){
                if(j !=i+1 && arr[j]==arr[j-1]){
                    continue;
                }
                int k=j+1;
                int l=n-1;
                while (k<l) {
                    long sum=arr[i];
                    sum+=arr[j];
                    sum+=arr[k];
                    sum+=arr[l];
                    if(sum==target){
                        ArrayList<Integer> inner=new ArrayList<>();
                        inner.add(arr[i]);
                        inner.add(arr[j]);
                        inner.add(arr[k]);
                        inner.add(arr[l]);
                        ans.add(inner);
                        k++;
                        l--;
                        while (k<l && arr[k]==arr[k-1]) {
                            k++;
                        }
                        while (k<l && arr[l]==arr[l-1]) {
                            l--;
                        }
                    }
                    else if(sum<target){
                        k++;
                    }
                    else{
                        l--;
                    }
                }
            }
        }
        return ans;
    }
}

package backtracking;
import java.util.*;
public class leetcode491 {
    public static void main(String[] args) {
        
    }
    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer= new ArrayList<>();
        // for(int num: arr){
        //     int n=outer.size();
        //     for(int i=0;i<n;i++){
        //         List<Integer> internal =new ArrayList<>(outer.get(i));
        //         internal.add(num);
        //         outer.add(internal);
        //     }
        // }
        // return outer;
        subset(0, arr,outer, new ArrayList<>());
        return outer;
    }
    private static void subset(int index, int[] arr,List<List<Integer>> ans, List<Integer> internalans){
        if(index==arr.length){
            ans.add(new ArrayList<>(internalans));
            return;
        }
        internalans.add(arr[index]);
        subset(index+1, arr, ans,internalans);
        internalans.remove(internalans.size()-1);
        subset(index+1, arr, ans, internalans); 
    }
}

// package binarysearch;
import java.util.Arrays;
public class leetcode2300 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(successfulPairs(new int[]{20,26,38,23,23,20,14,30},new int[]{24,1,7,26,19,17,7} , 510)));
    }
    static int[] successfulPairs(int[] spells, int[] potions, long success) {
        // int max=Math.max(potions.length ,spells.length);
        // int min=Math.min(potions.length ,spells.length);
        // int start1=0;
        // int end1=max-1;
        //int[] temp=spells.clone();
        //Arrays.sort(spells);
        Arrays.sort(potions);
        int[] count=new int[spells.length];
        int k=0;
        for(int i=0;i<spells.length;i++){
            int start=0;
            int end=potions.length-1;
            int ans=potions.length;
            while(start<=end){
                int mid=start+(end-start)/2;
                long pro=(long)(spells[i]*potions[mid]);
                if(pro>=success){
                    ans=mid;
                    end=mid-1;
                }
                if(pro<success){
                    start=mid+1;
                }
            }
            count[k++]=potions.length-ans;
        }
        return count;
    }
}

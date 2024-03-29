package slidingwindow;
import java.util.*;
public class leetcode2962 {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1,3,2,3,3}, 2));
    }
    public static long countSubarrays(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max=Math.max(max,nums[i]);
        }
        int cnt=0;
        for (int i : nums) {
            if (i==max) {
                cnt++;
            }
        }
        if(cnt<k){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int st=0;
        long ans=0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            while(map.containsKey(max) && map.get(max)>=k) {
                map.put(nums[st],map.get(nums[st])-1);
                st++;
            }
            ans+=st;
        }
        return ans;
    }
}

package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leetcode974 {
    public static void main(String[] args) {
        leetcode974 sol = new leetcode974();
        System.out.println(sol.subarraysDivByK(new int[]{-1,2,9}, 2));
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(10);
        System.out.println(sol.maxSize(list, 5));
        System.out.println(sol.maxLen(new int[]{15,-2,2,-8,1,7,10,23}, 8));
    }
    public int subarraysDivByK(int[] nums, int k) {
        if(nums.length==1 && nums[0]%k!=0){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0,1);
        for(int i =0;i<nums.length;i++){
            sum+=nums[i];
            count+=map.getOrDefault(sum%k,0);
            map.put(sum%k,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
    public int maxSize(List<Integer> a,int x){
        int max = -1;
		int sum = 0;
		int en = 0;
		int st = 0;
		while(en<a.size()){
			sum+=a.get(en);
			
			while(st<en && sum%x==0){
				sum-=a.get(st);
				st++;
			}
			if (sum%x!=0){
				max = Math.max(max,en-st+1);
			}
            en++;
		}
		return max;
    }
    //15,-2,2,-8,1,7,10,23
    public int maxLen(int nums[], int n){
        // Your code here
        int left = 0;
        int sum =0;
        int right =0;
        int max = Integer.MIN_VALUE;
        while(right<nums.length){
            sum+=nums[right];
            while(left<right && sum>0){
                sum-=nums[left];
                left++;
            }
            if(sum==0){
                max = Math.max(max,right-left+1);
            }

            right++;
        }
        return max;
    }
}

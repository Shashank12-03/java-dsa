
public class leetcode930 {
    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{0,0,0,0,0}, 0));
        System.out.println(numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2}, 2));
    }
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        cnt[0] = 1;
        int ans = 0, t = 0;
        for (int v : nums) {
            t += v;
            if (t - goal >= 0) {
                ans += cnt[t - goal];
            }
            cnt[t]++;
        }
        return ans;
        // HashMap<Integer,Integer> map=new HashMap<>();
        // int sum=0;
        // int count=0;
        // map.put(0, 1);
        // for (int i = 0; i < nums.length; i++) {
        //     sum+=nums[i];
        //     count+=map.getOrDefault(sum-goal, 0);
        //     if (map.containsKey(sum)) {
        //         map.put(sum,map.get(sum)+1);
        //     }
        //     else{
        //         map.put(sum,1);
        //     }
        // }
        // return count;
    }
    //leetcode 1248
    public static int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        cnt[0] = 1;
        int ans = 0, t = 0;
        for (int v : nums) {
            t += v & 1;
            if (t - k >= 0) {
                ans += cnt[t - k];
            }
            cnt[t]++;
        }
        return ans;
        // HashMap<Integer,Integer> map=new HashMap<>();
        // int odd=0;
        // int count=0;
        // map.put(0,1);
        // for (int i = 0; i < nums.length; i++){
        //     if(nums[i]%2!=0){
        //         odd++;
        //     }
        //     count+=map.getOrDefault(odd-k,0);
        //     if (map.containsKey(odd)) {
        //         map.put(odd,map.get(odd)+1);
        //     }
        //     else{
        //         map.put(odd,1);
        //     }
        // }
        // return count;
    }
}
package slidingwindow;

public class leetcode1493 {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
    }
    public static int longestSubarray(int[] nums) {
        int cnt = 0;
        int maxCnt = 0;
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==1){
                cnt++;
            }else{
                if (flag == 1){
                    cnt--;
                    flag = 0;
                }else{
                    cnt++;
                    flag= 1;
                }
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        return maxCnt;
    }
}

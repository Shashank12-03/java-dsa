package slidingwindow;


public class leetcode1052{
    public static void main(String[] args) {
        System.out.println(maxSatisfied(new int[]{1,0,1,2,1,1,7,5},new int[]{0,1,0,1,0,1,0,1}, 3));
    }
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0;
        for(int i = 0;i < grumpy.length; i++){
            if(grumpy[i]==0){
                sum += customers[i];
            }
        }
        int maxsum = sum;
        for (int i = 0; i < minutes; i++) {
            if(grumpy[i]==1){
                sum+=customers[i];
            }
        }
        maxsum = Math.max(maxsum, sum);
        for (int i = minutes; i < grumpy.length; i++) {
            if(grumpy[i-minutes]==1){
                sum-=customers[i-minutes];
            }
            if (grumpy[i]==1){
                sum+=customers[i];
            }
            maxsum = Math.max(maxsum,sum);
        }
        return maxsum;
    }
}
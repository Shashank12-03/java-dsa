package slidingwindow;

public class leetcode1423 {
    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1,2,3,4,5,6,1}, 3));
    }
    public static int maxScore(int[] cardPoints, int k) {
        int minsubarray=0;
        int total_sum=0;
        int n=cardPoints.length;
        for (int i = 0, current_sum=0; i < n; i++) {
            total_sum+=cardPoints[i];
            current_sum+=cardPoints[i];
            if(i<(n-k)){
                minsubarray+=cardPoints[i];
            }
            else{
                current_sum-=cardPoints[i-(n-k)];
                minsubarray=Math.min(minsubarray, current_sum);
            }
        }
        
        return total_sum-minsubarray;
    }
}

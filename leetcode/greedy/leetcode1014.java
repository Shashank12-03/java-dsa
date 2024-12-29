package greedy;


public class leetcode1014 {
    public static void main(String[] args) {
        leetcode1014 sol = new leetcode1014();
        int[] values = {8, 1, 5, 2, 6};
        int result = sol.maxScoreSightseeingPair(values);
        System.out.println("Max score: " + result);
    }
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int maxValue = values[0];
        int max = Integer.MIN_VALUE;
        for(int k = 1;k<n;k++){
            maxValue = Math.max(maxValue,values[k-1] + k-1);
            max = Math.max(max,maxValue+values[k] - k);
        }
        return max;
    }
}

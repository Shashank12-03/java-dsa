package arrays;

public class leetcode1395 {
    public static void main(String[] args) {
        leetcode1395 sol = new leetcode1395();
        System.out.println(sol.numTeams(new int[]{2,5,3,4,1}));
        // System.out.println(sol.numTeams(new int[]{2,1,3}));
        // System.out.println(sol.numTeams(new int[]{1,2,3,4}));

    }
    public int numTeams(int[] rating) {
        int res = 0;
        for (int i = 1; i < rating.length-1; i++) {
            int leftMin = 0;
            int leftMax = 0;
            for (int j = 0; j < i; j++) {
                if(rating[j]>rating[i]){
                    leftMax++;
                }
                if(rating[j]<rating[i]){
                    leftMin++;
                }
            }
            int rightMin = 0;
            int rightMax = 0;
            // 2 5 3 4 1
            for (int j = i+1; j <rating.length; j++) {
                if(rating[j]>rating[i]){
                    rightMax++;
                }
                if(rating[j]<rating[i]){
                    rightMin++;
                }
            }
            
            res+= (leftMin*rightMax)+(leftMax*rightMin);
        }
        return res;
    }
}

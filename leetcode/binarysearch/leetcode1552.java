import java.util.Arrays;

public class leetcode1552 {
    public static void main(String[] args) {
        
    }
    public static int maxDistance(int[] position, int m) {
        int ans = -1;
        Arrays.sort(position);
        int start = 1;
        int end = position[position.length-1]-position[0];
        while (start<=end) {
            int mid = start + (end-start)/2;
            if(inrange(position,m,mid)){
                ans = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }
    private static boolean inrange(int[] position, int m, int mid) {
        int range = 1;
        int last = position[0];
        for (int i = 1; i < position.length; i++) {
            if(position[i]-last>= mid){
                range++;
                last = position[i];
            }
        }
        return range>=m;
    }
}

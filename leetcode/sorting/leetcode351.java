package sorting;
import java.util.Arrays;

public class leetcode351 {
    public static void main(String[] args) {
        int[] arr={1,1,4,2,1,3};
        System.out.println(heightChecker(arr));
    }
    static int heightChecker(int[] heights) {
        int[] temp= new int[heights.length];
        temp=heights.clone();
        Arrays.sort(heights);
        int c=0;
        for(int i=0;i<heights.length;i++){
            if(heights[i]!=temp[i]){
                c++;
            }
        }
        return c;
    }
}

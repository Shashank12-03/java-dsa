package arrays;

public class leetcode768 {
    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{0,1,2,3,4}));
    }
    public static int maxChunksToSorted(int[] arr) {
        int max = -1;
        int res = 0;
        for(int i = 0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
            if(max==i){
                res++;
            }
        }
        return res;
    }
}

package arrays;

public class leetcode1574 {
    public static void main(String[] args) {
        leetcode1574 sol = new leetcode1574();
        System.out.println(sol.findLengthOfShortestSubarray(new int[]{4,4,8,10,5}));
    }
    
    public int findLengthOfShortestSubarray(int[] arr) {
        int preFixEnd = 0;
        int suffixEnd = 0;
        int i = 1;
        while(i<arr.length){
            if(arr[i]<arr[i-1]){
                preFixEnd = i-1;
                break;
            }
            i++;
        }
        i = arr.length-1;
        while(i>0){
            if(arr[i]<arr[i-1]){
                suffixEnd = i;
                break;
            }
            i--;
        }
        System.out.println(preFixEnd);
        System.out.println(suffixEnd);
        int result = Math.min(arr.length-preFixEnd-1,suffixEnd-1);
        i = 0;
        int j = suffixEnd;
        while( i<=preFixEnd && j<arr.length){
            if(arr[i]<=arr[j]){
                i++;
                result = Math.min(result,j-i);
            }
            else{
                j++;
            }
        }
        return result;
    }
}

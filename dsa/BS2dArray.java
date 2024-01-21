import java.util.Arrays;

public class BS2dArray {
    public static void main(String[] args) {
    int[][] arr={{-1,3}/* ,{15,25,35},{18,28,38}*/};
        int[] ans=BinarySearch2d(arr,3);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] BinarySearch2d(int[][] arr,int target){
        int row=0;
        int col=arr[0].length-1;
        while(row< arr.length && col>=0){
            if(arr[row][col]==target){
                return new int[]{row,col};
            }
            if(target<arr[row][col]){
                col--;
            }
            else{
                row++;
            }
        }
        return new int[]{-1,-1};
    }
}

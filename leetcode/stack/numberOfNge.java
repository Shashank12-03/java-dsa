package stack;

import java.util.Arrays;

public class numberOfNge {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(count_NGEs(8,new int[]{3, 4, 2, 7, 5, 8, 10, 6},2,new int[]{0,5})));
    }
    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        // code here
        for (int i = 0; i < queries; i++) {
            int count = 0;
            for(int j = indices[i]+1;j < N;j++){
                if(arr[indices[i]]<=arr[j]){
                    count++;
                }
            }
            indices[i] = count;
        }
        return indices;
    }
}

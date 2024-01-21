package sorting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class leetcode15 {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans= threeSum(arr);
        for(List<Integer> list:ans){
            System.out.println(list);
        }
    }
    static List<List<Integer>> threeSum(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();

        Arrays.sort(arr); // Sort the array in ascending order

        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue; // Skip duplicate elements to avoid duplicates in the result
            }

            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(arr[i]);
                    triplet.add(arr[left]);
                    triplet.add(arr[right]);
                    outer.add(triplet);

                    // Move the pointers to skip duplicate elements
                    while (left < right && arr[left] == arr[left + 1]) {
                        left++;
                    }
                    while (left < right && arr[right] == arr[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return outer;
    }
}

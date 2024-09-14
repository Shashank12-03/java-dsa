package arrays;

public class leetcode493 {
    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{1,3,2,3,1}));
    }
    static int count;
    public static int reversePairs(int[] nums) {
        count=0;
        merge(nums,0,nums.length-1);
        return count;
    }
    private static int[] merge(int[] nums, int start, int end) {
        if(start == end) {
            int[] arr = new int[1];
            arr[0] = nums[start];
            return arr;
        }
        int[] left = merge(nums,start,(start+end)/2);
        int[] right = merge(nums,1+((start+end)/2),end);
        int[] ret = new int[end-start+1];
        int ind = 0;
        int i = 0,j=0;
        while(i<left.length && j< right.length) {
            if(left[i]>2*(long)right[j]) {
                count+=left.length-i;
                j++;
            } else {
                i++;
            }
        }
        i=0;
        j=0;
        while(i<left.length && j< right.length) {
            if(left[i]>right[j]) {
                ret[ind++] = right[j];
                j++;
            } else {
                ret[ind++] = left[i];
                i++;
            }
        }
        while(i<left.length) {
            ret[ind++] = left[i++];
        } 
        while(j<right.length) {
            ret[ind++] = right[j++];
        }
        return ret;
    }
    // private static int countPairs(int[] arr, int low, int mid, int high) {
    //     int right = mid + 1;
    //     int count = 0;
    //     for (int i = low; i <= mid; i++) {
    //         while (right <= high && arr[i] > 2 * arr[right]) right++;
    //         count += (right - (mid + 1));
    //     }
    //     return count;
    // }
    // private static int mergeSort(int[] arr, int low, int high) {
    //     int count = 0;
    //     if (low >= high) return count;
    //     int mid = (low + high) / 2 ;
    //     count += mergeSort(arr, low, mid); 
    //     count += mergeSort(arr, mid + 1, high); 
    //     count += countPairs(arr, low, mid, high);
    //     merge(arr, low, mid, high);
    //     return count;
    // }
    // private static void merge(int[] arr, int low, int mid, int high) {
    //     ArrayList<Integer> temp = new ArrayList<>(); 
    //     int left = low;    
    //     int right = mid + 1;   

    //     while (left <= mid && right <= high) {
    //         if (arr[left] <= arr[right]) {
    //             temp.add(arr[left]);
    //             left++;
    //         } else {
    //             temp.add(arr[right]);
    //             right++;
    //         }
    //     }

    //     while (left <= mid) {
    //         temp.add(arr[left]);
    //         left++;
    //     }

    //     while (right <= high) {
    //         temp.add(arr[right]);
    //         right++;
    //     }

    //     for (int i = low; i <= high; i++) {
    //         arr[i] = temp.get(i - low);
    //     }
    // }
    
}



// public class leetcode560 {
//     public static void main(String[] args) {
//         System.out.println(subarraySum(new int[]{1}, 0));
//     }
//     public static int subarraySum(int[] nums, int k) {
//         int sum=0;
//         int start=0;
//         int count=0;
//         for(int i=0;i<nums.length;i++){
//             sum+=nums[i];
            
//         }

//     }
// }
    // static List<List<Integer>> subsetRep(int[] arr){
    //     Arrays.sort(arr);
    //     List<List<Integer>> outer= new ArrayList<>();
    //     outer.add(new ArrayList<>());
    //     int start=0;
    //     int end=0;
    //     for(int i=0;i<arr.length;i++){
    //         start=0;
    //         if(i>0 && arr[i]==arr[i-1]){
    //             start=end+1;
    //         }
    //         end=outer.size();
    //         int n=outer.size();
    //         for(int j=start;j<n;j++){
    //             List<Integer> internal =new ArrayList<>(outer.get(j));
    //             internal.add(arr[i]);
    //             outer.add(internal);
    //         }
    //     }
    //     return outer;
    // }
    

package slidingwindow;

public class leetcode904 {
    public static void main(String[] args) {
        leetcode904 sol = new leetcode904();
        System.out.println(sol.totalFruit(new int[]{1,2,3,2,2}));
    }
    public int totalFruit(int[] arr) {
        int maxFruit = 0;
        for (int fruit : arr) {
            if (fruit > maxFruit) {
                maxFruit = fruit;
            }
        }

        int left,right,maxLen,fruit;
        left=right=maxLen=fruit=0;
        int[] freq = new int[maxFruit+1];
        // 3 3 3 1 2 1 1 2
        // 0 1 1 3
        while(right<arr.length){
            if(freq[arr[right]]==0){
                fruit++;
            }
            freq[arr[right]]++;
            while(fruit>2){
                if(freq[arr[left]]!=0){
                    freq[arr[left]]--;
                }
                if(freq[arr[left]]==0){
                    fruit--;   
                }
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1); //3 4 
            right++;
        }
        return maxLen;
    }
}

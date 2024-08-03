package slidingwindow;

public class leetcode424 {
    public static void main(String[] args) {
        
    }
    public int characterReplacement(String s, int k) {
        // int A = 0;
        // int B = 0;
        // char[] arr =s.toCharArray(); 
        // for(char ch:arr){
        //     if(ch=='A'){
        //         A++;
        //     }
        //     else{
        //         B++;
        //     }
        // }
        // int left = 0;
        // int right = 0;
        // int maxLength = 0;
        // if (A>=B){
        //     B = 0;
        //     while(right<arr.length){
        //         if(arr[right]=='B'){
        //             B++;
        //         }
        //         while(B>k){
        //             if(left<right &&arr[left]=='B'){
        //                 B--;
        //             }
        //             left++;
        //         }
        //         maxLength = Math.max(maxLength,right-left+1);
        //         right++;
        //     }
        // }else{
        //     A = 0;
        //     while(right<arr.length){
        //         if(arr[right]=='A'){
        //             A++;
        //         }
        //         while(B>k){
        //             if(left<right && arr[left]=='A'){
        //                 A--;
        //             }
        //             left++;
        //         }
        //         maxLength = Math.max(maxLength,right-left+1);
        //         right++;
        //     }
        // }
        // return maxLength;

        //we start with checking the frequrncy of each character and storing it in freq 
        // update the max freq 
        // we check the length of our substring without the max character freq if its greater than k 
        // we decrement it till greater than k
        
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int maxF = 0;
        int[] freq = new int[26];
        char[] arr = s.toCharArray();
        while(right<arr.length){
            freq[arr[right]-'A']++;
            maxF = Math.max(maxF,freq[arr[right]-'A']);
            while((right-left+1)-maxF>k){
                freq[arr[left]-'A']--;
                maxF = 0;
                for(int i =0;i<26;i++){
                    maxF = Math.max(maxF,freq[i]);
                }
                left++;
            }
            if((right-left+1)-maxF<=k){
                maxLen = Math.max(maxLen,right-left+1);
            }
            right++;
        }
        return maxLen;
    }
}

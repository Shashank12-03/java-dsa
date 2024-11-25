package slidingwindow;

public class leetcode2516 {
    public static void main(String[] args) {
        leetcode2516 sol = new leetcode2516();
        System.out.println(sol.takeCharacters("aabbccca", 2));
    }

    public int takeCharacters(String s, int k) {
        int n = s.length();
        if(n<3*k){
            return -1;
        }
        int[] word = new int[3];

        for(char ch:s.toCharArray()){
            word[ch-'a']++;
        }
        if (word[0]<k || word[1]<k || word[2]<k) {
            return -1;
        }
        int start = 0;
        int end = 0;
        int maxLen = 0;
        int[] window = new int[3];
        while(end<n){

            char ch = s.charAt(end);
            
            window[ch-'a']++;
            
            while (window[0]>word[0]-k || window[1]>word[1]-k || window[2]>word[2]-k) {
                window[s.charAt(start)-'a']--;
                start++;
            }
            maxLen = Math.max(maxLen,end-start+1);
            end++;
        }
        return n-maxLen;
    }
}

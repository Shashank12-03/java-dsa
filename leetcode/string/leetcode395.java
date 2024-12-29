package string;

public class leetcode395 {
    public static void main(String[] args) {
        leetcode395 sol = new leetcode395();
        System.out.println(sol.longestSubstring("bbaaacbd", 3));
    }
    public int longestSubstring(String s, int k) {
        int[] freq = new int[26];
        int max = 0;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
            if(check(freq,k)){
                max = Math.max(max,i+1); 
            }
        }
        return max;
    }
    private boolean check(int[] freq, int k){
        for(int i = 0;i<26;i++){
            if(freq[i]!=0){
                if(freq[i]<k){
                    return false;
                }
            }
        }
        return true;
    }
}

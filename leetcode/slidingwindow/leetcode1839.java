package slidingwindow;

public class leetcode1839 {
    public static void main(String[] args) {
        leetcode1839 sol = new leetcode1839();
        System.out.println(sol.longestBeautifulSubstring("aeeeiiiioooauuuaeiou"));
    }
    public int longestBeautifulSubstring(String word) {
        if (word.length()<5){
            return 0;
        }
        String vowel = "aeiou";
        int maxLen = 0;
        int len = 0;
        int j =0;
        for(int i =0;i<word.length();i++){
            if(j<5 && word.charAt(i)==vowel.charAt(j)){
                len++;
            }
            else if(j<4 && word.charAt(i)==vowel.charAt(j+1)){
                len++;
                j+=1;
            }
            else{
                len = 0;
                j = 0;
            }
            if (j+1==5) {
                maxLen = Math.max(len,maxLen);
            }
        }
        return maxLen;
    }
}

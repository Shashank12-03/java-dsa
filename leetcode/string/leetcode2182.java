package string;

public class leetcode2182 {
    public static void main(String[] args) {
        leetcode2182 sol = new leetcode2182();
        System.out.println(sol.repeatLimitedString("cczazcc", 3));
    }

    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        
        StringBuilder ans = new StringBuilder();
        int i = 25;
        while (i>=0) {
            char ch = (char)(i+'a');
            int rep = 0;
            while (freq[i]>0) {
                ans.append(ch);
                rep++;
                freq[i]--;
                if (rep==repeatLimit && freq[i]>0) {
                    int j = i-1;
                    while (j>=0 && freq[j]==0) {
                        j--;
                    }
                    if (j<0) {
                        return ans.toString();
                    }
                    else{
                        ans.append((char)(j+'a'));
                        rep = 0;
                        freq[j]--;
                    }
                }
            }
            i--;
        }
        return ans.toString();
    }
}

class Pair {
    char ch;
    int freq;
    Pair(char ch,int freq){
        this.ch = ch;
        this.freq = freq;
    }
}
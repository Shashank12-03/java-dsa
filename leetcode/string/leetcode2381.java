package string;

import java.util.Arrays;

public class leetcode2381 {

    public static void main(String[] args) {
        String s = "xuwdbdqik";
        int[][] shifts = {
            {4, 8, 0}, {4, 4, 0}, {2, 4, 0}, {2, 4, 0}, 
            {6, 7, 1}, {2, 2, 1}, {0, 2, 1}, {8, 8, 0}, {1, 3, 1}
        };
        leetcode2381 solution = new leetcode2381();
        String result = solution.shiftingLetters(s, shifts);
        System.out.println(result);
    }
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] freq = new int[n];
        for(int[] shift:shifts){
            if(shift[2]==0){
                freq[shift[0]] += -1;
                if(shift[1]<n-1){
                    freq[shift[1]+1] += 1;
                }
            }
            else{
                freq[shift[0]] += 1;
                if(shift[1]<n-1){
                    freq[shift[1]+1] += -1;
                }
            }
        }
        for(int i = 1;i<n;i++){
            freq[i] = freq[i] + freq[i-1];
        }
        System.out.println(Arrays.toString(freq));
        StringBuilder ans = new StringBuilder();
        for(int i = 0;i<n;i++){
            freq[i] = freq[i]%26;
            if((s.charAt(i)-'a')+freq[i]>=26){
                ans.append((char)('a'+((s.charAt(i)-'a')+freq[i])-26));
            }
            else if((s.charAt(i)-'a')+freq[i]<0){
                ans.append((char)('a'+ 26+((s.charAt(i)-'a')+freq[i])));
            }
            else{
                ans.append((char)(s.charAt(i)+freq[i]));
            }
        }
        return ans.toString();
    }
}
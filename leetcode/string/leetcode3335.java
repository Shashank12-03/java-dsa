package string;

import java.util.Arrays;

public class leetcode3335 {
    public static void main(String[] args) {
        leetcode3335 obj = new leetcode3335();
        String s = "jqktcurgdvlibczdsvnsg";
        int t = 7517;
        int result = obj.lengthAfterTransformations(s, t);
        System.out.println(result);
    }
    
    public int lengthAfterTransformations(String s, int t) {
        // z 58
        // ab 57
        // abz 31
        // bcab 30
        // yzxy 7
        // zabyz 6
        // abbczab 5 
        // bccdabbc 4
        // after 26 operations we get one more
        // aa = 0
        // a = 2
        // zz = 25
        // abab = 26
        // zabzab = 51
        // abbcabbc = 52
        // b = 0 
        // z = 24 
        // ab = 25 
        // zab = 50 
        // abbc = 51
        int[] freq = new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        System.out.println(Arrays.toString(freq));
        int length = 0;
        int mod = 1000000007;
        for(int i = 0;i<26;i++){
            if(freq[i]>0){
                long count = (long) freq[i] * ((t + i) / 26 + 1);
                length = (int) ((length + count) % mod);
            }
        }
        return length;
    }
}

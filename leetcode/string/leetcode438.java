package string;
import java.util.*;
public class leetcode438 {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
    
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        for(int i=p.length();i<=s.length();i++){
            if(areAllCharactersPresent(s.substring(i-p.length(), i),p)){
                ans.add(i-p.length());
            }
        }
        return ans;
    }
    public static boolean areAllCharactersPresent(String str1, String str2) {
        // Check if the lengths are the same
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] charArray1=new int[26];
        int[] charArray2=new int[26];
        // Convert strings to character arrays for easier manipulation
        for(int i=0;i<str1.length();i++){
            charArray1[str1.charAt(i)-'a']++;
            charArray2[str2.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(charArray1[i]!=charArray2[i]){
                return false;
            }
        }
        return true;
        // charArray1 = str1.toCharArray();
        // charArray2 = str2.toCharArray();
        // for(int i=0;i<charArray1.length;i++){
        //     if(charArray1[i]!=charArray2[i]){
        //         return false;
        //     }
        // }
        // return true;
        

        // Compare the sorted character arrays
        
    }
}

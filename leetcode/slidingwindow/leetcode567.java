package slidingwindow;

//import java.util.Arrays;

public class leetcode567 {
    public static void main(String[] args) {
        System.out.println(checkInclusion("adc","dcda"));
    }
    public static boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int k = n1, left = 0;
        int[] arr = new int[26];
        char[] s2Arr = s2.toCharArray();

        for (char c : s1.toCharArray()) ++arr[c - 'a'];

        for (int right = 0; right < n2; right++) {
            if (arr[s2Arr[right] - 'a']-- > 0) k--;

            while (k == 0) {
                if (right - left + 1 == n1) return true;
                if (++arr[s2Arr[left++] - 'a'] > 0) k++;
            }
        }
        return false;
    }
    // public static boolean checkInclusion(String s1, String s2) {
    //     int[] string1=new int[26];
    //     for (char ch : s1.toCharArray()) {
    //         string1[ch-'a']++;
    //     }
    //     int[] string2=new int[26];
    //     for (int i = 0; i < s1.length(); i++) {
    //         string2[s2.charAt(i)-'a']++;
    //     }
    //     boolean is_permutation=check(string1, string2);
    //     if(is_permutation){
    //         return is_permutation;
    //     }
    //     Arrays.fill(string2, 0);
    //     for (int j = 1; j < s2.length(); j++) {
    //         for (int i = 0+j; i < s1.length()+j; i++) {
    //             if (i<string1.length) {
    //                 string2[s2.charAt(i)-'a']++;
    //             }
    //         }
    //         is_permutation=check(string1, string2);
    //         if(is_permutation){
    //             return is_permutation;
    //         }
    //         Arrays.fill(string2, 0);
    //     }
    //     return is_permutation;
    // }
    // public static boolean check(int[] string1,int[] string2){
    //     for (int i = 0; i < 26; i++) {
    //         if(string1[i]!=string2[i]){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}

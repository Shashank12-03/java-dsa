package arrays;

import java.util.Arrays;

public class leetcode2599 {
    public static void main(String[] args) {
        String[] words = {
            "ebnnporwiufimntatuaoadwbxrtrt", "xjjqnrjkkbto", "tkubqyxihhxikigwlnkikxhsfxmhl", 
            "xeezqycyn", "ewrdylevbatctcydoqjcmixffplhdvcxy", "erhrezicc", "b", 
            "lgildbphjsiechluqedoor", "vsuvhhkaxvdvipmlpxkawyuektwwyq", "xvirozecg", 
            "mxzreujgplnza", "lvwtmnpkswiyoheshvyjjhgzvwayv", "ykbonftzsuuv", "tpbyufbbqpe", 
            "nozcjouwqrxup", "o", "bzvicojsvpvaglmveonqabc", "jefoabkhvaikfnjgamzbvisoff", 
            "tihdokbjutzwmuukkol", "rjbqfnmoccwhidzzqekaudnsrhkybggicvmvbgch"
        };
        System.out.println(words.length);
        int[][] queries = {
            {7, 10}, {6, 9}, {12, 13}, {17, 18}, {5, 10}, {12, 12}, {17, 19}, {1, 18}, 
            {13, 18}, {3, 11}, {6, 14}, {9, 10}, {3, 19}, {13, 18}, {17, 18}, {5, 7}, 
            {3, 12}, {9, 11}, {15, 17}, {7, 15}, {18, 18}, {2, 17}
        };
        System.out.println(queries.length);
        leetcode2599 obj = new leetcode2599();
        int[] result = obj.vowelStrings(words, queries);
        System.out.println(Arrays.toString(result));
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] temp = new int[words.length];
        if(isVowel(words[0])){
            temp[0] = 1;
        }
        for(int i = 1;i<words.length;i++){
            String str = words[i];
            if(isVowel(str)){
                temp[i] = 1 + temp[i-1];
            }else{
                temp[i] = temp[i-1];
            }
        }
        int[] ans = new int[queries.length];
        for(int i = 0;i<queries.length;i++){
            if(queries[i][0]==0){
                ans[i] = temp[queries[i][1]];
            }
            else{
                ans[i] = temp[queries[i][1]] - temp[queries[i][0]-1];
            }
        }
        return ans;
    }

    private boolean isVowel(String string){
        char s = string.charAt(0);
        char e = string.charAt(string.length()-1);
        if ((s=='a' || s=='e' || s=='i' || s=='o' || s=='u') && (e=='a' || e=='e' || e=='i' || e=='o' || e=='u')){
            return true;
        }
        return false;
    }
}

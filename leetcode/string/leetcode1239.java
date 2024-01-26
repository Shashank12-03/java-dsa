package string;

import java.util.*;
public class leetcode1239 {
    public static void main(String[] args) {
        List<String> str=new ArrayList<>();
        str.add("cha");
        str.add("r");
        str.add("act");
        str.add("ers");
        System.out.println(maxLength(str));
    }
    public static int maxLength(List<String> arr) {
        int[] store=new int[26];
        int max_length=0;
        int length=0;
        String str="";
        for (int i = 0; i < arr.size(); i++) {
            String str1=arr.get(i);
            for (int j = i+1; j < arr.size(); j++) {
                String str2=arr.get(j);
                str=str1+str2;
                length=str.length();
                for (int j2 = 0; j2 < 26; j2++) {
                    if (j2<length) {
                        store[str.charAt(j2)-'a']++;
                    }
                    else{
                        break;
                    }
                }
                if (check(store)) {
                    max_length=Math.max(max_length,length);
                }
                str="";
                Arrays.fill(store,0);
            }
        }
        return max_length;
    }
    public static boolean check(int[] nums){
        for (int i = 0; i < 26; i++) {
            if(nums[i]>1){
                return false;
            }
        }
        return true;
    }
}

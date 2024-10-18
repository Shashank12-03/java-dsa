package arrays;

import java.util.*;

public class leetcode2938 {
    public static void main(String[] args) {
        leetcode2938 sol = new leetcode2938();
        System.out.println(sol.minimumSteps("11000111"));
    }
    public long minimumSteps(String s) {
        char[] str = s.toCharArray();
        int first = -1;
        int second = 0;
        int third = 1;
        int cnt = 0;
        while(third<str.length){
            if(first!=-1 && (str[first]=='1' &&  str[second]=='0')){
                cnt++;
                char temp = str[first];
                str[first] = str[second];
                str[second] = temp;
            }
            if(str[second]=='1' && str[third]=='0'){
                cnt++;
                char temp = str[second];
                str[second] = str[third];
                str[third] = temp;
            }
            first++;
            second++;
            third++;
        }
        System.out.println(Arrays.toString(str));
        return cnt;
    }
}

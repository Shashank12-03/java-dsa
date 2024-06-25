package string;

import java.util.ArrayList;
import java.util.List;

public class leetcode17{
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
    public static List<String> letterCombinations(String digits) {
        return keypad("", digits);
    }
    static List<String> keypad(String p, String up){
        if(up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit= up.charAt(0)-'0';
        int st = (digit-2)*3;
        if(digit>7){
            st+=1;
        }
        int len=st+3;
        if (digit==7 && digit==9){
            len+=1;
        }
        List<String> list = new ArrayList<>();
        for(int i=st;i<len;i++){
            char ch=(char)('a'+ i);
            list.addAll(keypad(p+ch, up.substring(1)));
        }
        return list;
    }
}
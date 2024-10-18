package stack;

public class leetcode1963 {
    public static void main(String[] args) {
        System.out.println(minSwaps("]]][[["));
    }

    public static int minSwaps(String s) {
        int st = 0;
        int n = s.length();
        int en = n-1;
        int open = 0;
        int closing = 0;
        char[] str = s.toCharArray();
        int cnt = 0;
        while(st<en){
            if(str[st]=='['){
                open++;
            }
            else{
                closing++;
            }
            if(closing>open){
                while(str[en]==']'){
                    en--;
                }
                char ch = str[en];
                str[en] = str[st];
                str[st] = ch;
                cnt++;
                closing--;
                open++;
            }
            st++;
        }
        return cnt;
    }  
}


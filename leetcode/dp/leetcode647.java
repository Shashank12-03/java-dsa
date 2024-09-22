package dp;

public class leetcode647 {
    public static void main(String[] args) {
        leetcode647 sol = new leetcode647();
        System.out.println(sol.countSubstrings("fdsklf"));
    }
    public int countSubstrings(String text1) {
        int cnt = 0;
        for(int i =0;i<text1.length();i++){
            int left = i;
            int right = i;
            while(left>=0 && right<text1.length()){
                if(text1.charAt(left)==text1.charAt(right)){
                    cnt++;
                }
                left--;
                right++;
            }
            left = i;
            right = left+1;
            while(left>=0 && right<text1.length()){
                if(text1.charAt(left)==text1.charAt(right)){
                    cnt++;
                }
                left--;
                right++;
            }
        }
        return cnt;
    }
}

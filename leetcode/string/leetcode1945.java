package string;

public class leetcode1945 {
    public static void main(String[] args) {
        System.out.println(getLucky("iiii", 1));
    }
    public static int getLucky(String s, int k) {
        StringBuilder str = new StringBuilder();
        for(char ch:s.toCharArray()){
            str.append(String.valueOf(ch-'a'+1));
        }
        System.out.println(str);
        int ans = 0; 
        while(k>0){
            int sum = 0;
            for(int i =0;i<str.length();i++){
                sum+=Integer.parseInt(str.substring(i,i+1));
            }
            ans = sum;
            str = new StringBuilder(String.valueOf(sum));
            k--;
        }
        return ans;
    }
}

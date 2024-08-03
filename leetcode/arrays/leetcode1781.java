package arrays;

public class leetcode1781 {
    public static void main(String[] args) {
        System.out.println(beautySum("aabcb"));
    }
    public static int beautySum(String s) {
        int sum =0;
        for(int i =0;i<s.length();i++){
            int[] store = new int[26];
            store[s.charAt(i)-'a']++;
            for(int j =i+1;j<s.length();j++){
                store[s.charAt(j)-'a']++;
                int max = 0;
                int min = Integer.MAX_VALUE;
                for(int k=0;k<26;k++){
                    max = Math.max(max,store[k]);
                    if(store[k]!=0){
                        min = Math.min(min,store[k]);
                    }
                }
                if(min!=0){
                    sum+=max-min;
                }
            }
        }
        return sum;
    }
}

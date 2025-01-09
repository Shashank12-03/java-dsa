package string;

public class leetcode3042 {
    public static void main(String[] args) {
        leetcode3042 solution = new leetcode3042();
        String[] words = {"abc", "ababc", "abcabc", "a"};
        int result = solution.countPrefixSuffixPairs(words);
        System.out.println("Number of prefix-suffix pairs: " + result);
    }
    public int countPrefixSuffixPairs(String[] words) {
        int pairs = 0;
        for(int i = 0;i<words.length;i++){
            String str = words[i];
            int strLen = str.length();
            for(int j = i+1;j<words.length;j++){
                String string = words[j];
                int stringLen = string.length();
                if(strLen<stringLen){
                    String prefix = string.substring(0,strLen);
                    String suffix = string.substring(stringLen-strLen,stringLen);
                    if(prefix.equals(str) && suffix.equals(str)){
                        pairs++;
                    }
                }
            }
        }
        return pairs;
    }
}

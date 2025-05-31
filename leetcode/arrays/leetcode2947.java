package arrays;

public class leetcode2947 {
    public static void main(String[] args) {
        leetcode2947 obj = new leetcode2947();
        String input = "baeyh";
        // 0 1 2 2 2 
        // 0 1 2 3 4
        int k = 2; // Example value for k
        int result = obj.beautifulSubstrings(input, k);
        System.out.println("Number of beautiful substrings: " + result);
    }
    public int beautifulSubstrings(String s, int k) {
        int ans = 0;
        int subString = 0;
        // int [] prefix = new int[s.length()]; 
        int vowels = 0;
        for(int j = 0;j<s.length();j++){
            char ch = s.charAt(j);
            if(isVowel(ch)){
                vowels++;
            }
            
            if(2*vowels==(j+1) && (vowels*vowels)%k==0){
                subString++;
                // prefix[j] = prefix[j-1] + 1;
                ans+=subString;
            }
            // else{
            //     prefix[j] = prefix[j-1];
            // }
        }
        return ans;
    }
    public boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch); // Convert to lowercase for uniformity
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}

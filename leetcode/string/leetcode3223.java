package string;

public class leetcode3223 {
    public static void main(String[] args) {
        
    }
    // the intuition behind the solution is if we have to remove a character we require 3 same character one on which we are standing one to the left and one to the right. so here after operation left and right will get removed so remaining will be one 
    // what we do here is we count the freq of each character in the string
    //  if the character frequency is even then we know ifts greater than 2 ie 4 6 8.. we can remove only 2 character in one operation 
    // "aaaa"-> "aa" -> now this cannot be change further as no left 'a' for index 0 and no right'a' for index 1
    // so when even freq occcurs we add 2 to our answer
    // now in case of odd freq ie 3 5 7...
    // we know on each operation 2 char getting removed so here we will left with only one see below example 
    // "aaaaa" -> "aaa"-> "a" so at the end of the odd freq only one char will remain so we add one to the ans 
    
    public int minimumLength(String s) {
        int[] freq = new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        int ans = 0;
        for(int i = 0;i<26;i++){
            if(freq[i]!=0){
                if(freq[i]%2==0){
                    ans+=2;
                }
                else{
                    ans++;
                }
            }
        }
        return ans;
    }
}

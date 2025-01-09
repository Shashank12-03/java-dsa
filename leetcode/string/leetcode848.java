package string;

public class leetcode848 {
    public static void main(String[] args) {
        
    }
    public String shiftingLetters(String s, int[] shift) {
        int n = shift.length;
        for(int i =n-1;i>0;i--){
            shift[i] = shift[i]%26;
            shift[i-1] = shift[i-1] + shift[i];
        }
        StringBuilder ans = new StringBuilder();
        int j = 0;
        for(int i =0;i<n;i++){
            shift[i] = shift[i]%26;
            if((s.charAt(j)-'a')+shift[i]>=26){
                ans.append((char)('a'+((s.charAt(j)-'a')+shift[i])-26));
            }
            else if((s.charAt(i)-'a')+shift[i]<0){
                ans.append((char)('a'+ 26+((s.charAt(j)-'a')+shift[i])));
            }
            else{
                ans.append((char)(s.charAt(j)+shift[i]));
            }
            j++;
        }
        return ans.toString();
    }
}

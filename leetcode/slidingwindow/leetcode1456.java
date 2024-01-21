package slidingwindow;
public class leetcode1456{
    public static void main(String[] args) {
        System.out.println(maxVowels("leetcode", 3));
    }
    public static int maxVowels(String s, int k) {
        int count=0;
        for(int i=0;i<k;i++){
            if(isvowel(s.charAt(i))){
                count++;
            }
        }
        if(count==k){
            return count;
        }
        int count1=count;
        for(int i=k;i<s.length();i++){
            char first=s.charAt(i-k);
            char startk=s.charAt(i);
            if(isvowel(first)){
                count--;
            }
            if(isvowel(startk)){
                count++;
            }
            count1=Math.max(count1, count);
        }
        return count1;
    }
    public static boolean isvowel(char vow){
        if(vow== 'a'|| vow== 'e'||vow== 'i'||vow== 'o'||vow== 'u'){
            return true;
        }
        return false;
    }
}
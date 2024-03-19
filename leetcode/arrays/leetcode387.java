package arrays;
public class leetcode387 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
    public static int firstUniqChar(String s) {
        char[] str=s.toCharArray();        int[] store=new int[26];
        for (char ch:str) {
            store[(int) ch-'a']++;
        }
        for (int i = 0; i < str.length; i++){
            if(store[(int)str[i]-'a']==1){
                return i;
            }
            else{
                continue;
            }
        }
        return -1;
    }
}

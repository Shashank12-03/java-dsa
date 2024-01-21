package string;

public class leetcode299 {
    public static void main(String[] args) {
        System.out.println(getHint("1234","0111"));
    }
    public static String getHint(String secret, String guess) {
        int bulls=0;
        int cows=0;
        int[] guess_nums=new int[9];
        int[] secret_nums=new int[9];
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                bulls++;
            }
            else{
                guess_nums[guess.charAt(i)-'0']++;
                secret_nums[secret.charAt(i)-'0']++;
            }
        } 
        for(int i=0;i<guess_nums.length;i++){
            if(guess_nums[i]!=0 && secret_nums[i]!=0){
                if(secret_nums[i]!=guess_nums[i]){
                    cows+=(Math.abs(secret_nums[i]-guess_nums[i]));
                }
                else{
                    cows++;
                }
            }
        }
        String ans= bulls+"A"+cows+"B";
        return ans;
    }
}

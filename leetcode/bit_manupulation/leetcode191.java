package bit_manupulation;

public class leetcode191 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(11111111));
    }
    public static int hammingWeight(int n) {
        int count=0;
        while(n>0){
            int last=n&1;
            if(last==1){
                count++;
            }
            n=n>>1;
        }
        return count;
    }
}

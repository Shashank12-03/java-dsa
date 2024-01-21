package bit_manupulation;

public class leetcode201 {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(2,3));
    }
    public static int rangeBitwiseAnd(int left, int right) {
        if(left==right){
            return left&right;
        }
        if(left<2){
            return 0;
        }
        int nearest=1;
        int ans=0;
        while (nearest<left) {
            nearest=nearest*2;
            ans++;
        }
        return ans;
    }
}

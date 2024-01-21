package binarysearch;
public class leetcode633 {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(1000000000));
    }
    static boolean judgeSquareSum(int c) {
        int a=0;
        int b=c;
        while(a<=b){
            int sq=(int)Math.pow(a, 2)+(int)Math.pow(b, 2);
            if(sq==c){
                return true;
            }
            if(sq<c){
                a++;
            }
            if(sq>c){
                b--;
            }
        }
        return false;
    }
}

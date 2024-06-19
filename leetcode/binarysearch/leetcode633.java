package binarysearch;
public class leetcode633 {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(2147482647));
    }
    static boolean judgeSquareSum(int c) {
        long st = 0;
        long en = (int) Math.sqrt(c);
        while (st<=en) {
            if((st*st)+(en*en) == c ){
                return true;
            }
            if ((st*st)+(en*en) > c){
                en--;
            }else{
                st++;
            }
        }
        return false;
    }
}

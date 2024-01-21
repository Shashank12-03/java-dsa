package string;

public class leetcode400 {
    public static void main(String[] args) {
        System.out.println(findNthDigit(100000000));
    }
    public static int findNthDigit(int n) {
        StringBuilder answer=convert(n);
        String ans=answer.toString();
        return (ans.charAt(n-1)-'0');
    }
    static StringBuilder convert(int n){
        StringBuilder p=new StringBuilder("");
        for(int i=1;i<=n;i++){
            p.append(i);
        }
        return p;
    }
}

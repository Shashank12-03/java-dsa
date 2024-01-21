public class leetcode99 {
    public static void main(String[] args){
        System.out.println(numTrees(5));
    }
    public static int numTrees(int n) {
        double product=1;
        for(int i=2;i<=n;i++){
            product=product*((double)(n+i)/i);
        }
        return (int)Math.ceil(product);
    }
    // public static int fact(int num){
    //     if(num==1){
    //         return 1;
    //     }
    //     return num*fact(num-1);
    // }
}

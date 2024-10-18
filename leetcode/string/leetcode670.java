package string;


public class leetcode670 {
    public static void main(String[] args) {
        leetcode670 sol = new leetcode670();
        System.out.println(sol.maximumSwap(2736));
    }
    public int maximumSwap(int num) {
        String str = String.valueOf(num);
        char[] numChar =  str.toCharArray();   
        for(int i =0;i<numChar.length;i++){
            int max = 0;
            for(int j = numChar.length-1;j>=i;j--){
                if(numChar[i]<numChar[j] && max < numChar[j]-'0'){
                    char ch = numChar[i];
                    numChar[i] = numChar[j];
                    numChar[j] = ch;
                    max = numChar[j]-'0';
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < numChar.length; i++) {
            ans+=numChar[i]-'0';
            ans *= 10;
        }
        return ans/10;
    }
}

package arrays;


public class leetcode1545 {
    public static void main(String[] args) {
        leetcode1545 sol = new leetcode1545();
        System.out.println(sol.findKthBit(20, 1));
    }
    public char findKthBit(int n, int k) {
        String[] arr = new String[n + 1];  
        arr[0] = "0";  
        
        for (int i = 1; i <= n; i++) {
            String previous = arr[i - 1];
            arr[i] = previous +  "1"+ reverse(invert(previous));
            System.out.println(" "+ i + "  " + arr[i]);
            System.out.println( "                                 -----------------------------                                     ");
        }
        return arr[n].charAt(k-1);
    }
    public String invert(String s) {
        StringBuilder inverted = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '0') {
                inverted.append('1');
            } else {
                inverted.append('0');
            }
        }
        return inverted.toString();
    }
    public String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}

package string;

public class leetcode2337 {
    public static void main(String[] args) {
        leetcode2337 sol = new leetcode2337();
        System.out.println(sol.canChange("_L__R__R_", "L______RR"));
    }
    public boolean canChange(String start, String target) {
        int i = 0;
        int j = 0;
        int n = start.length();
        while(i<n || j<n){
            while(i<n && start.charAt(i)=='_'){
                i++;
            }
            while(j<n && target.charAt(j)=='_'){
                j++;
            }
            if(i==n || j==n){
                return i==n && j==n;
            }
            if((start.charAt(i)!=target.charAt(j)) || (start.charAt(i)=='R' && i>j) || (start.charAt(i)=='L' && i<j)){
                return false;
            }
            i++;
            j++;
        
        }
        return true;
    }
}

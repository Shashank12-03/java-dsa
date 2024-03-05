package arrays;

public class leetcode1750 {
    public static void main(String[] args) {
        
    }
    public static int minimumLength(String s) {
        int left=0;
        int right=s.length()-1;
        while (left<right && s.charAt(left)==s.charAt(right)) {
            char temp=s.charAt(left);
            while (left<=right && s.charAt(left)==temp) {
                left++;
            }
            while (left<=right && s.charAt(right)==temp) {
                right--;
            }
        }
        return right-left+1;
    }
}

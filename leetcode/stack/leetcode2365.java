import java.util.Stack;

public class leetcode2365 {
    public static void main(String[] args) {
        leetcode2365 obj = new leetcode2365();
        String pattern = "IIDID";
        // 124365
        String result = obj.smallestNumber(pattern);
        System.out.println("The smallest number for the pattern " + pattern + " is: " + result);
    }
    // first what is given 
    // what is expected
    // explain using example
    // explain approach using example
    // code explain while coding
    // final entire explanation  
    // we have given a string IIDID we want to construct another number string which should be lexographically smallest number than other string
    // In the string if char is I then nums[i]<nums[i+1]
    // In the string if char is I then nums[i]>nums[i+1]
    // The number should be in range 1 to 9 
    // If we want to have smallest number its observative that we should not consider number greater than the length of string 
    // Suppose stirng IIIIDDDD
    // Here its preety obvious that if we want to have smallest number and the string is starting with I then we are 100% going to start with 1
    // so till D the possible string is 1 2 3 4 5 
    // so now from D as we cant use previous character and we dont know whats further coming we keep storing the number in stack till I appears
    // so the stack further is [6 7 8 9]
    // as we do not encounter any I after it and the traversed the string and the stack is not empty we start popping the numbers so 
    // final string in this case is 1 2 3 4 5 9 8 7 6
    // but suppose we have string IIIIDIII
    // now first we push the number in stack and if the character is I we have to immediately take out it and append to the string as
    // stack is first in last out so if we have I and we push the number and do not pop it and in next iteration we are pushing next number then its gonna be come first while popping 
    // so it will reverse the order and we cant get the next number greater than current 
    // therefore we pop the number immediately if the character is I
    public String smallestNumber(String pattern) {
        Stack<Character> stack = new Stack<>();
        StringBuilder ans  = new StringBuilder();
        char[] patt = pattern.toCharArray();
        for(int i = 0;i<=patt.length;i++){
            stack.push((char)('0'+ i + 1)); 
            while(!stack.isEmpty() && (i==patt.length || patt[i]=='I')){
                ans.append((char)(stack.pop()));
            }
        }
        return ans.toString();
    }
}

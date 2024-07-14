package stack;

import java.util.Stack;

public class leetcode1717 {
    public static void main(String[] args) {
        System.out.println(maximumGain("", 4, 5));
    }
    public static int maximumGain(String s, int x, int y) {
        int maxSum = 0;
        String highPriorityPair = x>y ? "ab" : "ba" ;
        String lowPriorityPair = highPriorityPair.equals("ab") ? "ba":"ab";

        String firstPass = removeString(s,highPriorityPair);
        int removedPairsCount =
            (s.length() - firstPass.length()) / 2;

        // Calculate score from first pass
        maxSum += removedPairsCount * Math.max(x, y);

        // Second pass: remove low priority pair
        String stringAfterSecondPass = removeString(
            firstPass,
            lowPriorityPair
        );
        removedPairsCount = (firstPass.length() -
            stringAfterSecondPass.length()) /
        2;

        // Calculate score from second pass
        maxSum += removedPairsCount * Math.min(x, y);

        return maxSum;

    }
    private static String removeString(String s, String targetPair) {
        Stack<Character> charStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == targetPair.charAt(1) && !charStack.isEmpty() && charStack.peek() == targetPair.charAt(0)){
                charStack.pop();
            }else{
                charStack.push(currentChar);
            }
        }
        StringBuilder remainingChars = new StringBuilder();
        while (!charStack.isEmpty()) {
            remainingChars.append(charStack.pop());
        }
        return remainingChars.reverse().toString();
    }
}

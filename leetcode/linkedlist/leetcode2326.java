package linkedlist;

import java.util.Arrays;

public class leetcode2326 {

    public static ListNode createLinkedList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        
        return head;
    }
    public static void main(String[] args) {
        int[] values = {515,942,528,483,20,159,868,999,474,320,734,956,12,124,224,252,909,732};
        ListNode head = createLinkedList(values);
        int[][] ans = spiralMatrix(4, 5, head);
        for (int[] is : ans) {
            System.out.println(Arrays.toString(is));
        }
    }
    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        // Initialize the matrix with -1
        for (int[] row : ans) {
            Arrays.fill(row, -1);
        }

        // Define boundaries for the spiral
        int left = 0, right = n - 1, up = 0, down = m - 1;
        int row = 0, col = 0;

        // Traverse the matrix in a spiral order
        while (head != null) {
            // Move right across the top row
            while (col <= right && head != null) {
                ans[row][col] = head.val;
                col++;
                head = head.next;
            }
            col--; // Move back one step
            row++; // Move to the next row
            up++;  // Shrink upper boundary

            // Move down the right column
            while (row <= down && head != null) {
                ans[row][col] = head.val;
                row++;
                head = head.next;
            }
            row--; // Move back one step
            col--; // Move to the left column
            right--; // Shrink right boundary

            // Move left across the bottom row
            while (col >= left && head != null) {
                ans[row][col] = head.val;
                col--;
                head = head.next;
            }
            col++; // Move back one step
            row--; // Move to the upper row
            down--; // Shrink bottom boundary

            // Move up the left column
            while (row >= up && head != null) {
                ans[row][col] = head.val;
                row--;
                head = head.next;
            }
            row++; // Move back one step
            col++; // Move to the right column
            left++; // Shrink left boundary
        }

        return ans;
    }
}

package Trees;

import java.util.Arrays;

public class leetcode109 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val){ 
            this.val = val; 
        }
        ListNode(int val, ListNode next){ 
            this.val = val; 
            this.next = next; 
        }
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        
    }
    public TreeNode sortedListToBST(ListNode head) {
        int[] list=list(head);
        return sortedArrayToBST(list);
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null){
            return null;
        }
        TreeNode root= new TreeNode(nums[nums.length/2]);
        int[]left=Arrays.copyOfRange(nums, 0, nums.length/2);
        int[]right=Arrays.copyOfRange(nums, (nums.length/2)+1, nums.length);
        root.left=sortedArrayToBST(left);
        root.right=sortedArrayToBST(right);
        return root;
    }
    public int[] list(ListNode head) {
        int[] list = new int[length(head)];
        int i = 0;
        ListNode temp = head;
        
        while (temp != null) {
            list[i++] = temp.val;
            temp = temp.next;
        }
        
        return list;
    }

    public int length(ListNode head) {
        int count = 0;
        ListNode temp = head;
        
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        
        return count;
    }
    
}
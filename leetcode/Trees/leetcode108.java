package Trees;

import java.util.Arrays;

public class leetcode108 {
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null){
            return null;
        }
        TreeNode root= new TreeNode(nums[nums.length/2]);
        int[]left=Arrays.copyOfRange(nums, 0, nums.length/2);
        int[]right=Arrays.copyOfRange(left, (nums.length/2)+1, nums.length);
        root.left=sortedArrayToBST(left);
        root.right=sortedArrayToBST(right);
        return root;
    }
}

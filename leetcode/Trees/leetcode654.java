import java.util.Arrays;

public class leetcode654 {
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int index=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max, nums[i]);
            index=i;
        }
        TreeNode node=new TreeNode(max);
        node.left=constructMaximumBinaryTree(Arrays.copyOfRange(nums,0, index));
        node.right=constructMaximumBinaryTree(Arrays.copyOfRange(nums,index+1,nums.length));
        return node;
    }
}

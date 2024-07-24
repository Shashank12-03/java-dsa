package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class leetcode99 {
    public static void main(String[] args){
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2, node7, node4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, node6, node2);

        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node1 = new TreeNode(1, node0, node8);

        TreeNode root = new TreeNode(3, node5, node1);
        
        recoverTree(root);
    }
    public static void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        System.out.println(list);
        // Collections.sort(list);
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i); 
        }
        // Arrays.sort(arr);
        Collections.sort(list);
        int firstInd = -1;
        int secondInd = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=list.get(i)){
                if (firstInd!=-1){
                    secondInd = i;
                }else{
                    firstInd = i;
                }
            }
        }
        int temp = arr[firstInd];
        arr[firstInd] = arr[secondInd];
        arr[secondInd]= temp;
        root = sortedArrayToBST(arr);
    }
    private static void helper(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        TreeNode root= new TreeNode(nums[nums.length/2]);
        int[]left=Arrays.copyOfRange(nums, 0, nums.length/2);
        int[]right=Arrays.copyOfRange(nums, (nums.length/2)+1, nums.length);
        root.left=sortedArrayToBST(left);
        root.right=sortedArrayToBST(right);
        return root;
    }
}

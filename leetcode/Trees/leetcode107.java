

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode107 {
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result= new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> store= new LinkedList<>();
        store.offer(root);
        while(!store.isEmpty()){
            int levelsize=store.size();
            List<Integer> level= new ArrayList<>(levelsize);
            for(int i=0;i<levelsize;i++){
                TreeNode currentnode=store.poll();
                level.add(currentnode.val);
                if(currentnode.left!=null){
                    store.offer(currentnode.left);
                }
                if(currentnode.right!=null){
                    store.offer(currentnode.right);
                }
            }
            result.add(level);
        }
        Collections.reverse(result);
        return result;
    }
    // public static void reverseList(List<List<Integer>>list) {
    //     int left = 0;
    //     int right = list.size() - 1;

    //     while (left < right) {
    //         // Swap elements at the left and right indices
    //         List<Integer> temp = list.get(left);
    //         list.set(left, list.get(right));
    //         list.set(right, temp);

    //         // Move the indices towards each other
    //         left++;
    //         right--;
    //     }
    // }
}

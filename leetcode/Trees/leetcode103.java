

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode103 {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result= new ArrayList<>();
        boolean reverse=false;
        if(root==null){
            return result;
        }
        Deque<TreeNode> store= new LinkedList<>();
        store.offer(root);
        while(!store.isEmpty()){
            int levelsize=store.size();
            List<Integer> level= new ArrayList<>(levelsize);
            for(int i=0;i<levelsize;i++){
                if(!reverse){
                    TreeNode currentnode=store.pollFirst();
                    level.add(currentnode.val);
                    if(currentnode.left!=null){
                        store.addLast(currentnode.left);
                    }
                    if(currentnode.right!=null){
                        store.addLast(currentnode.right);
                    }
                }
                else{
                    TreeNode currentnode=store.pollLast();
                    level.add(currentnode.val);
                    if(currentnode.right!=null){
                        store.addFirst(currentnode.right);
                    }
                    if(currentnode.left!=null){
                        store.addFirst(currentnode.left);
                    }
                }
            }
            reverse=!reverse;
            result.add(level);
        }
        return result;
    }
    // public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    //     List<List<Integer>> result= new ArrayList<>();
    //     //boolean reverse=false;
    //     int count=0;
    //     if(root==null){
    //         return result;
    //     }
    //     Deque<TreeNode> store= new LinkedList<>();
    //     store.offer(root);
    //     while(!store.isEmpty()){
    //         int levelsize=store.size();
    //         List<Integer> level= new ArrayList<>(levelsize);
    //         for(int i=0;i<levelsize;i++){
    //             TreeNode currentnode=store.pollFirst();
    //             level.add(currentnode.val);
    //             if(currentnode.right!=null){
    //                 store.offerLast(currentnode.right);
    //             } 
    //             if(currentnode.left!=null){
    //                 store.offerLast(currentnode.left);
    //             }
    //             count++;
    //             if(count%2!=0){
    //                 reverseList(level);
    //             }
    //         }
    //         result.add(level);
    //     }
    //     return result;
    // }
    // public static void reverseList(List<Integer> list) {
    //     int left = 0;
    //     int right = list.size() - 1;

    //     while (left < right) {
    //         // Swap elements at the left and right indices
    //         Integer temp = list.get(left);
    //         list.set(left, list.get(right));
    //         list.set(right, temp);

    //         // Move the indices towards each other
    //         left++;
    //         right--;
    //     }
    // }
}

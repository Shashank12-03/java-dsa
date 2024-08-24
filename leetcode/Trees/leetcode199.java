package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode199 {
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result= new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> store= new LinkedList<>();
        store.offer(root);
        while(!store.isEmpty()){
            int levelsize=store.size();
            for(int i=0;i<levelsize;i++){
                TreeNode currentnode=store.poll();
                if(i==levelsize-1){
                    result.add(currentnode.val);
                }
                if(currentnode.left!=null){
                    store.offer(currentnode.left);
                }
                if(currentnode.right!=null){
                    store.offer(currentnode.right);
                }
            }
        }
        return result;
    }
    // ArrayList<Integer> arr;
    // public List<Integer> rightSideView(TreeNode root) {
    //     arr = new ArrayList();
    //     traverse(root,0);
    //     return arr;
    // }
    // public void traverse(TreeNode root,int len){
    //     if(root==null) return;
    //     if(len==arr.size()) arr.add(root.val);
    //     traverse(root.right,len+1);
    //     traverse(root.left,len+1);
    // }
}

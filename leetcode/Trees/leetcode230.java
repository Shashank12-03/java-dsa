// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Queue;

public class leetcode230 {
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
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        return helper(root, k).val;
        // Queue<TreeNode> store= new LinkedList<>();
        // store.offer(root);
        // while(!store.isEmpty()){
        //     int levelsize=store.size();
        //     for(int i=0;i<levelsize;i++){
        //         TreeNode currentnode=store.poll();
        //         result.add(currentnode.val);
        //         if(currentnode.left!=null){
        //             store.offer(currentnode.left);
        //         }
        //         if(currentnode.right!=null){
        //             store.offer(currentnode.right);
        //         }
        //     }
        // }
        // Collections.sort(result);
        // return result.get(k);

    }
    private TreeNode helper(TreeNode root,int k) {

        if(root==null){
            return null;
        }
        TreeNode left=helper(root.left,k);
        if(left!=null){
            return left;
        }
        count++;
        if(count==k){
            return root; 
        }
        return helper(root.right, k);
    }
}

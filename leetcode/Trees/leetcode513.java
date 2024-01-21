import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode513 {
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
    public int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> result= new ArrayList<>();
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
        List<Integer> anslist=result.get((result.size()-1));
        return anslist.get(0);
    }
}

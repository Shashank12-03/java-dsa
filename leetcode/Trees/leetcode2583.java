import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode2583 {
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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> store=new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
        store.offer(root);
        while(!store.isEmpty()){
            int levelsize=store.size();
            int sum=0;
            for(int i=0;i<levelsize;i++){
                TreeNode currentnode=store.poll();
                sum+=currentnode.val;
                if(currentnode.left!=null){
                    store.offer(currentnode.left);
                }
                if(currentnode.right!=null){
                    store.offer(currentnode.right);
                }
            }
            ans.add(sum);
        }
        if(ans.size()<k){
            return -1;
        }
        else{
            Collections.sort(ans);
            return ans.get(ans.size()-k);
        }
    }
}

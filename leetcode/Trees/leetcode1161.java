import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode1161 {
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
    public int maxLevelSum(TreeNode root) {
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
        int answer=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<ans.size();i++){
            if(max<ans.get(i)){
                max=ans.get(i);
                answer=i+1;
            }
        }
        return answer;
    }
}

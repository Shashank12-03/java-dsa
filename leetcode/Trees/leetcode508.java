package Trees;
import java.util.*;
public class leetcode508 {
    public static void main(String[] args) {
        
    }
    HashMap<Integer,Integer> map=new HashMap<>();
    int max=0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root==null) {
            return new int[]{};
        }
        findFrequentSum(root);
        ArrayList<Integer> list=new ArrayList<>();
        for (Integer key :map.keySet()) {
            if (map.get(key)==max) {
                list.add(key);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i]=list.get(i);
        }
        return ans;
    }
    private void findFrequentSum(TreeNode root) {
        if (root==null) {
            return ;
        }
        findFrequentSum(root.left);
        findFrequentSum(root.right);
        int sum=root.val;
        if (root.left!=null) {
            sum+=root.left.val;
        }
        if (root.right!=null) {
            sum+=root.right.val;
        }
        if (map.containsKey(sum)) {
            map.put(sum,map.get(sum)+1);
        }else{
            map.put(sum,1);
        }
        root.val=sum;
        max=Math.max(max,map.get(sum));
    }

}
class TreeNode {
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

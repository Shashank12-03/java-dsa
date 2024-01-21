
public class leetcode1301 {
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
    public int deepestLeavesSum(TreeNode root) {
        return helper(root,maxdepth(root));
        // Queue<TreeNode> store=new LinkedList<>();
        // List<Integer> levelsum=new ArrayList<>();
        // store.add(root);
        // int sum=0;
        // while(!store.isEmpty()){
        //     int levelsize=store.size();
        //     for(int i=0;i<levelsize;i++){
        //         TreeNode cnode=store.poll();
        //         sum+=cnode.val;
        //         if(cnode.left!=null){
        //             store.offer(cnode.left);
        //         }
        //         if(cnode.right!=null){
        //             store.offer(cnode.right);
        //         }
        //     }
        //     levelsum.add(sum);
        // }
        // return levelsum.get(levelsum.size()-1);
    }
    public int maxdepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=maxdepth(root.left);
        int right=maxdepth(root.right);
        return Math.max(left, right)+1;
    }
    public int helper(TreeNode root, int depth){
        if(depth==1){
            return root.val;
        }
        int left= helper(root.left, depth-1);
        int right= helper(root.right, depth-1);
        return left+right;
    }
}

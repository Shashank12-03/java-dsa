package Trees;

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
    int leftmost=0;
    int lastrow=-1;
    public int findBottomLeftValue(TreeNode root) {
        visit(root,0);
        return leftmost;
    }
    private void visit(TreeNode root, int depth) {
        if (root==null) {
            return;
        }
        if (depth>lastrow) {
            leftmost=root.val;
            lastrow=depth;
        }
        visit(root.left, depth+1);
        visit(root.right, depth+1);
    }
    // public int findBottomLeftValue(TreeNode root) {
    //     List<List<Integer>> result= new ArrayList<>();
    //     Queue<TreeNode> store= new LinkedList<>();
    //     store.offer(root);
    //     while(!store.isEmpty()){
    //         int levelsize=store.size();
    //         List<Integer> level= new ArrayList<>(levelsize);
    //         for(int i=0;i<levelsize;i++){
    //             TreeNode currentnode=store.poll();
    //             level.add(currentnode.val);
    //             if(currentnode.left!=null){
    //                 store.offer(currentnode.left);
    //             }
    //             if(currentnode.right!=null){
    //                 store.offer(currentnode.right);
    //             }
    //         }
    //         result.add(level);
    //     }
    //     List<Integer> anslist=result.get((result.size()-1));
    //     return anslist.get(0);
    // }
    
}

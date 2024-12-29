package Trees;

// import java.util.LinkedList;
// import java.util.Queue;

public class leetcode114 {
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
    public void flatten(TreeNode root) {
        // Queue<TreeNode> ans=getqueue(root);
        // TreeNode current = ans.poll();
        // while (!ans.isEmpty()) {
        //     current.left = null;
        //     current.right = ans.poll();
        //     current = current.right;
        // }
        TreeNode node=root;
        while(node!=null){
            if(node.left!=null){
                TreeNode temp=node.left;
                while(temp.right!=null){
                    temp=temp.right;
                }
                temp.right=node.right;
                node.right=node.left;
                node.left=null;
            }
            node=node.right;
        }
    }
    // private Queue<TreeNode> getqueue(TreeNode root) {
    //     Queue<TreeNode> store= new LinkedList<>();
    //     if(root!=null){
    //         store.offer(root);
    //         store.addAll(getqueue(root.left));
    //         store.addAll(getqueue(root.right));
    //     }
    //     return store;
    // }

    
}

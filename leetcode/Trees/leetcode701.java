public class leetcode701 {
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insert(val, root);
    }
    private TreeNode insert(int value, TreeNode node){
        if(node==null){
            node = new TreeNode(value);
            return node;
        }
        if(value<node.val){
            node.left=insert(value, node.left);
        }
        if(value>node.val){
            node.right=insert(value, node.right);
        }
        //node.height=Math.max(height(node.left),height(node.right));
        return rotate(node);
    }
    public int height(TreeNode node){
        if(node==null){
            return 0;
        }
        int left=height(node.left);
        int right=height(node.right);
        return Math.max(left,right)+1;
    }
    public boolean isempty(TreeNode root){
        return root==null;
    }

    private TreeNode rotate(TreeNode node){
        if(height(node.left)-height(node.right)>1){
            //left heavy
            if(node.left!=null){
                if(height(node.left.left)-height(node.left.right)>0){
                    //left left case
                    return rightRotate(node);
                }
                if(height(node.left.left)-height(node.left.right)<0){
                    //left right case
                    node.left=leftRotate(node.left);
                    return rightRotate(node);
                }
            }
        }
        if(height(node.left)-height(node.right)>1){
            //right heavy
            if(node.right!=null){
                if(height(node.right.left)-height(node.right.right)<0){
                    //right right case
                    return rightRotate(node);
                }
                if(height(node.right.left)-height(node.right.right)>0){
                    //right left case
                    node.right=rightRotate(node.right);
                    return leftRotate(node);
                }
            }
        }
        return node;
    }
    public TreeNode rightRotate(TreeNode p){
        TreeNode c=p.left;
        TreeNode t=c.right;
        c.right=p;
        p.left=t;
        // p.height=Math.max(height(p.left),height(p.right)+1);
        // c.height=Math.max(height(c.left),height(c.right)+1);
        return c;
    }
    public TreeNode leftRotate(TreeNode c){
        TreeNode p=c.right;
        TreeNode t=p.left;
        p.left=c;
        c.right=t;
        // p.height=Math.max(height(p.left),height(p.right)+1);
        // c.height=Math.max(height(c.left),height(c.right)+1);
        return p;
    }
}

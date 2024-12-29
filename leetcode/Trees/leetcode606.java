package Trees;


public class leetcode606 {
    public static void main(String[] args) {
        leetcode606 sol = new leetcode606();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println(sol.tree2str(root));
    }
    //      1
    //    /   \
    //   2     3
    //    \
    //     4
    public String tree2str(TreeNode root) {
        StringBuilder str = new StringBuilder();
        helper(root,str);

        return str.substring(1,str.length()-1).toString();
    }
    private void helper(TreeNode root, StringBuilder str){
        if(root==null){
            return;
        }
        str.append('(');
        str.append(root.val);
        if(root.left==null && root.right!=null){
            str.append("()");
        }
        System.out.println(str);
        helper(root.left,str);
        helper(root.right,str);
        str.append(')');
    }
}

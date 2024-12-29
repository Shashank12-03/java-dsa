package Trees;

public class leetcode669 {
    public static void main(String[] args) {
        leetcode669 sol = new leetcode669();
        System.out.println(sol.trimBST(null, 0, 0));
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root==null){
            return root;
        }
        if (root.val<low){
            return trimBST(root.right, low, high);
        }
        if (root.val>high){
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}

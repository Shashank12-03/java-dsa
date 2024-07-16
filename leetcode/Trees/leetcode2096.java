package Trees;

public class leetcode2096 {
    public static void main(String[] args) {
        // 5,1,2,3,null,6,4
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);
        System.out.println(getDirections(root, 3, 6));

        //           5
        //       1       2
        //    3       6     4
    }

    public static String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode commonAncestor = lowestCommonAncestor(root, startValue, destValue);

        StringBuilder pathToStart = new StringBuilder();
        buildPath(pathToStart, commonAncestor, startValue,new char[] {'U'});

        StringBuilder pathToDest = new StringBuilder();
        buildPath(pathToDest, commonAncestor, destValue, new char[]{'L', 'R'});

        return pathToStart.append(pathToDest.reverse()).toString();
    }

    private static boolean buildPath(StringBuilder path, TreeNode root, int value, char[]directions) {
        if (root == null) return false;
        if (root.val == value) return true;

        if (root.left != null && buildPath(path, root.left, value, directions)) {
            path.append(directions[0]);  // Append 'L' if going left
            return true;
        }
        if (root.right != null && buildPath(path, root.right, value, directions)) {
            path.append(directions.length > 1 ? directions[1] : directions[0]);  // Append 'R' if going right
            return true;
        }
        return false;
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
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

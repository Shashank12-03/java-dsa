package Trees;

import java.util.ArrayList;

public class pathToLeaf {

    class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static void main(String[] args) {
        
    }
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        helper(paths,path,root);
        return paths;
    }
    private static void helper(ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path, Node root) {
        if (root == null){
            return;
        }
        path.add(root.data);
        if (root.left==null && root.right ==null){
            paths.add(new ArrayList<>(path));
        }
        
        helper(paths, path, root.left);
        helper(paths, path, root.right);
        path.remove(path.size()-1);
    }
}

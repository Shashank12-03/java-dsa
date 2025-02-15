package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leetcode988 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(1);

        leetcode988 solution = new leetcode988();
        System.out.println(solution.smallestFromLeaf(root));
    }

    public String smallestFromLeaf(TreeNode root) {
        List<String> list = new ArrayList<>();
        helper(root,list,new StringBuilder());
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        return list.get(0);
    }
    
    private void helper(TreeNode root, List<String> list, StringBuilder str){
        if(root==null){
            return;
        }
        
        str.append((char)(root.val + 'a'));
        if(root.left == null && root.right == null){
            StringBuilder strToAdd = new StringBuilder(str);
            list.add(strToAdd.reverse().toString());
        } else {
            helper(root.left,list,str);
            helper(root.right,list,str);
        }
        str.deleteCharAt(str.length()-1);
    
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

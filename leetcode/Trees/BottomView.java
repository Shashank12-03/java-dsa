package Trees;
import java.util.*;
public class BottomView {
    public class Node {
        int val;
        Node left;
        Node() {}
        Node right;
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        
    }
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        if (root == null) {
            return ans;
        }

        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 0));

        while (!queue.isEmpty()) {
            QueueNode qNode = queue.poll();
            int hd = qNode.horizontalDistance;
            map.put(hd, qNode.node.val);
            
            if (qNode.node.left != null) {
                queue.offer(new QueueNode(qNode.node.left, hd - 1));
            }
            if (qNode.node.right != null) {
                queue.offer(new QueueNode(qNode.node.right, hd + 1));
            }
        }

        for (int value : map.values()) {
            ans.add(value);
        }
        return ans;
    }

    public class QueueNode {
        Node node;
        int horizontalDistance;

        public QueueNode(Node node, int horizontalDistance) {
            this.node = node;
            this.horizontalDistance = horizontalDistance;
        }
    }
    // public static ArrayList <Integer> bottomView(TreeNode root){
    //     ArrayList<Integer> ans= new ArrayList<>();
    //     int[] store=new int[200000];
    //     helper(root,store,0);
    //     for (int i = 0; i < store.length; i++) {
    //         if (store[i]!=0) {
    //             ans.add(store[i]);
    //         }
    //     }
    //     return ans;
    // }
    // private static void helper(TreeNode root, int[] store, int index) {
    //     if (root==null) {
    //         return;
    //     }
    //     store[100000+index]=root.val;
    //     helper(root.left, store, index-1);
    //     helper(root.right,store,index+1);
    // }
    
}

package Trees;

public class cielBst {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.left.right.right = new Node(8);
        System.out.println(findCeil(root,6));
    }
    /*
     *    
     *     10
          /  \
         5    11
        / \ 
       4   7
            \
             8
     */
    public static int findCeil(Node root, int key) {
        // if (root == null) return -1;
        // // Code here
        int min = Integer.MAX_VALUE;
        while(root!=null){
            if(root.data ==key){
                return key;
            }
            if (root.data>key){
                min = Math.min(min,root.data);
                root = root.left;
            }
            else if (root.data<key){
                root = root.right;
            }
        }
        return min==Integer.MAX_VALUE? -1: min;
    }
    public static int findFloor(Node root, int key) {
        // if (root == null) return -1;
        // // Code here
        int max = Integer.MIN_VALUE;
        while(root!=null){
            if(root.data ==key){
                return key;
            }
            if (root.data>key){
                root = root.left;
            }
            else if (root.data<key){
                max = Math.max(max,root.data);
                root = root.right;
            }
        }
        return max==Integer.MIN_VALUE? -1: max;

    }
}

class Node { 
    int data; 
    Node left, right; 

    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}
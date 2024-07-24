package Trees;


public class largestBst{

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(4);
        root.right = new Node(4);
        root.left.left = new Node(6);
        root.left.right = new Node(8);

        System.out.println(largestbst(root));
    }

    public static int largestbst(Node root){
        Info info = largestbstSize(root);
        return info.size;
    }
    //       1
    //     /  \
    //     4   4              
    //    / \ 
    //   6   8
    private static Info largestbstSize(Node root) {
        if (root==null){
            return new Info(0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info left = largestbstSize(root.left);
        Info right = largestbstSize(root.right);
        if (root.data> left.max && root.data<right.min){
            int currSize = left.size+right.size+1;
            int max=Math.max(root.data,right.max);
            int min=Math.min(root.data,left.min);
            return new Info(currSize,min,max);
        }
        return new Info(Math.max(left.size,right.size),Integer.MIN_VALUE,Integer.MAX_VALUE);
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
class Info{
    int size;
    int min;
    int max;
    Info(int size,int min,int max){
        this.size = size;
        this.min = min;
        this.max = max;
        System.out.println("size " + size + " min " + min + " max " + max);
    }
}
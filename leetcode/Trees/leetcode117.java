
public class leetcode117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public static void main(String[] args) {
        
    }
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Node leftmost= root;
        while(leftmost.left!=null){
            Node current=leftmost;
            while(current!=null){
                if(current.left==null && current.right==null){
                    if(current.next.left!=null && current.next.right!=null){
                        current.next.left.next=current.next.right;
                    }
                    if(current.next.left!=null && current.next.right==null){
                        current.next.left.next=null;
                    }
                }
                if(current.left!=null){
                    if(current.right!=null){
                        current.left.next=current.right;
                    }
                    else{
                        if(current.next!=null){
                            if(current.next.left!=null){
                                current.left.next=current.next.left;
                            }
                            else{
                                if(current.next.right!=null){
                                    current.left.next=current.next.right;
                                }
                            }
                        }
                    }
                }
                if(current.next!=null){
                    if(current.next.left==null){
                        if(current.next.right!=null){
                            if(current.right!=null){
                                current.right.next=current.next.right;
                            }
                        }    
                    }
                    else{
                        current.right.next=current.next.left;
                    }
                    
                }
                current=current.next;
            }
            leftmost=leftmost.left;
        }
        return root;
    }
}

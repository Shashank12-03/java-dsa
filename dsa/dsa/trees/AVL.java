package dsa.trees;

public class AVL {
    public class Node{
        private int value;
        private Node left;
        private Node right;
        public Node(int value){
            this.value=value;
        }
        public int getValue(){
            return value;
        }
    }
    private Node root;
    public AVL(){

    }
    public int height(){
        return height(root);
    }
    private int height(Node node){
        if(root==null){
            return 0;
        }
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return Math.max(left,right)+1;
    }
    public boolean isempty(){
        return root==null;
    }
    public void insert(int value){
        root=insert(value, root);
    }
    private Node insert(int value, Node node){
        if(node==null){
            node = new Node(value);
            return node;
        }
        if(value<node.getValue()){
            node.left=insert(value, node.left);
        }
        if(value>node.getValue()){
            node.right=insert(value, node.right);
        }
        Math.max(height(node.left),height(node.right));
        return rotate(node);
    }
    private Node rotate(Node node){
        if(height(node.left)-height(node.right)>1){
            //left heavy
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
        if(height(node.left)-height(node.right)>1){
            //right heavy
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
        return node;
    }
    public Node rightRotate(Node p){
        Node c=p.left;
        Node t=c.right;
        c.right=p;
        p.left=t;
        Math.max(height(p.left),height(p.right)+1);
        Math.max(height(c.left),height(c.right)+1);
        return c;
    }
    public Node leftRotate(Node c){
        Node p=c.right;
        Node t=p.left;
        p.left=c;
        c.right=t;
        Math.max(height(p.left),height(p.right)+1);
        Math.max(height(c.left),height(c.right)+1);
        return p;
    }
    public void populate(int[] nums){
        for(int i=0;i<nums.length;i++){
            this.insert(nums[i]);
        }
    }
    public void populatesorted(int[] nums){
        populatesorted(nums,0,nums.length);
    }
    private void populatesorted(int[] nums, int start, int end) {
        if(start>=end){
            return;
        }
        int mid=(start+end)/2;
        this.insert(nums[mid]);
        populatesorted(nums, start, mid);
        populatesorted(nums, mid+1, end);
    }
    public void display(){
        display(root,"Root Node: ");
    }
    private void display(Node node,String details){
        if(node==null){
            return;
        }
        System.out.println(details+node.getValue());
        display(node.left, "Left child of "+node.getValue()+" ");
        display(node.right, "Right child of "+node.getValue()+" "); 
    }
    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node){
        if(node==null){
            return true;
        }
        return Math.abs(height(node.left)-height(node.right))<=1 && balanced(node.left) && balanced(node.right);
    }
}

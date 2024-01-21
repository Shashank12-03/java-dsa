package dsa.trees;

public class BSTmain {
    public static void main(String[] args) {
        // BinarySearchTree tree=new BinarySearchTree();
        // int[] nums={3,2,1,10,5,6,9,8,7};
        // tree.populate(nums);
        // tree.display();
        AVL tree= new AVL();
        for(int i=0;i<1000;i++){
            tree.insert(i);
        }
        System.out.println(tree.height());
    }
}

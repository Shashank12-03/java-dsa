package dsa.trees;

import java.util.Scanner;

public class binarytreesMain {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        binarytrees tree= new binarytrees();
        tree.populate(scanner);
        tree.preetydisplay();
    }
}

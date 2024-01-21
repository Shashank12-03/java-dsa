package dsa.linkedlist;

public class Main {
    public static void main(String[] args) {
        single();
       // Double();
    }
    static void single(){
        singlyLL list= new singlyLL();
        // list.insertfirst(10);
        // list.insertfirst(20);
        // list.insertfirst(30);
        // list.insertfirst(40);
        // list.insertfirst(50);
        list.insertlast(60);
        list.insertlast(60);
        // list.insert(70, 3);
        // System.out.println(list.deletefirst());
        // list.display();
        // System.out.println();
        // System.out.println(list.deletelast());
        // list.display();
        // System.out.println();
        // System.out.println(list.delete(3));
        // list.display();
        // System.out.println(list.size);
    }
    static void Double(){
        doublyLL list=new doublyLL();
        list.insertstart(20);
        list.insertstart(30);
        list.insertstart(40);
        list.insertstart(50);
        list.insertstart(60);
        list.insertend(10);
        list.deletestart();
        list.deleteend();
        list.display();
    }
}

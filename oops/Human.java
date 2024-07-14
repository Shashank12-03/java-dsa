package oops;

public class Human {
    String name;
    int age;
    int salary;
    boolean married;
    static long population;

    public Human(String name,
    int age,
    int salary,
    boolean married){
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.married = married;
        Human.population +=1; // can use this keyword for static variables as they are going to be static that is same for all objects so the this  will refer object and object is of human class so its better to use class name instead of this
    }
}

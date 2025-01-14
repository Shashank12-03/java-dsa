package Round996;


import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (Math.abs((a-b)%n)%2==0) {
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
        }

        scanner.close();
    }
}

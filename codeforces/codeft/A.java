package codeft;

import java.util.Scanner;

public class A {

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int[] array = new int[n];
            int count = 0;
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                array[j] = scanner.nextInt();
                if (array[j]%x==0) {
                    count++;
                    if (array[j]/x==1) {
                        flag = true;
                    }
                }
            }
            if (count!=0 && flag) {
                System.out.println(count);
            }
            else {
                System.out.println(-1);
            }
        }

        scanner.close();
    }
}
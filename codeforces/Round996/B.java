package Round996;

import java.util.Scanner;


public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] array1 = new int[n];
            int[] array2 = new int[n];

            for (int j = 0; j < n; j++) {
                array1[j] = scanner.nextInt();
            }

            for (int j = 0; j < n; j++) {
                array2[j] = scanner.nextInt();
            }
            B sol = new B();
            if (sol.helper(array1,array2)==true) {
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
        }
        scanner.close();
    }
    private boolean helper(int[] arr1, int[] arr2){
        int surplus = 0;
        int deficit = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] > arr2[i]) {
                surplus += arr1[i] - arr2[i];
            } else {
                deficit += arr2[i] - arr1[i];
            }
        }
        return surplus >= deficit;
    }
}

package greedy;


public class leetcode1332 {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);

        // int t = scanner.nextInt(); // Number of test cases

        // for (int i = 0; i < t; i++) {
        //     int M = scanner.nextInt(); // Number of police officers
        //     int x = scanner.nextInt(); // Maximum speed of police officers (houses/minute)
        //     int y = scanner.nextInt(); // Maximum duration of police search (minutes)

        //     int[] copHouses = new int[M];
        //     for (int j = 0; j < M; j++) {
        //         copHouses[j] = scanner.nextInt();
        //     }

        //     // Sort the array of police officer house numbers
        //     Arrays.sort(copHouses);

        //     // Calculate the maximum distance John can travel
        //     int maxDistance = x * y;

        //     // Calculate the number of safe houses
        //     int safeHouses = 0;
        //     for (int j = 1; j <= 100; j++) {
        //         boolean isSafe = true;
        //         for (int copHouse : copHouses) {
        //             if (Math.abs(copHouse - j) <= maxDistance) {
        //                 isSafe = false;
        //                 break;
        //             }
        //         }
        //         if (isSafe) {
        //             safeHouses++;
        //         }
        //     }

        //     System.out.println(safeHouses);
        // }

        // scanner.close();
        //System.out.println(minMovesToEmptyString(4, "abba"));
        System.out.println(minMovesToEmpty("abaabbbaaa"));
    }
    public static int minMovesToEmpty(String s) {
        // If the string is already a palindrome
        if (isPalindrome(s)) {
            return 1;
        }else{ 
            return 2; // In case of no mismatches found, it would take at least two moves
        }
    }
    
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
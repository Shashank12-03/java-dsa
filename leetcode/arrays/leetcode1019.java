package arrays;

import java.util.Arrays;

public class leetcode1019 {
    public static void main(String[] args) {
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        int[] result = new leetcode1019().corpFlightBookings(bookings, n);
        System.out.println(Arrays.toString(result));
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        Arrays.sort(bookings, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        for (int[] booking : bookings) {
            System.out.println(Arrays.toString(booking));
        }
        for (int i = 1; i < bookings.length; i++) {
            if (bookings[i][0] <= bookings[i - 1][1]) {
                bookings[i][2] += bookings[i - 1][2];
            }
        }
        for (int[] booking : bookings) {
            System.out.println(Arrays.toString(booking));
        }

        for (int i = 1; i <= n; i++) {
            int pot = 0;
            int l = i;
            int r = n;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (mid<bookings.length && bookings[mid][1] <= i) {
                    pot = bookings[mid][2];
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            ans[i - 1] = pot;
        }
        return ans;
    }
}

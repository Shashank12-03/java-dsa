package binarysearch;

public class nthRoot {
    public static void main(String[] args) {
        System.out.println(NthRoot(6, 4096));
    }
    public static int NthRoot(int n, int m)
    {
        int low = 1;
        int end = m;
        while (low <= end) {
            int mid = low + (end - low) / 2;
            long check = 1;
            for (int i = 0; i < n; i++) {
                check *= mid;
                if (check > m) {
                    break;
                }
            }
            if (check == m) {
                return mid;
            } else if (check > m) {
                end = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

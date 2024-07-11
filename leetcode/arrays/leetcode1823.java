package arrays;


// import java.util.LinkedList;
// import java.util.Queue;

public class leetcode1823 {
    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));
    }
    public static int findTheWinner(int n, int k) {
        // Queue<Integer> queue = new LinkedList<>();
        // int i = 1;
        // while (i<=n) {
        //     queue.offer(i);
        //     i++;
        // }
        // while (queue.size()!=1) {
        //     int j =1;
        //     while (j<k) {
        //         int temp = queue.peek();
        //         queue.offer(temp);
        //         queue.poll();
        //         j++;
        //     }
        //     queue.poll();
        // }
        // return queue.peek();
        if(n==1) return 1;
        return (findTheWinner(n-1,k)+k-1)%n+1;
    }
}

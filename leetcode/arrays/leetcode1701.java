package arrays;

public class leetcode1701 {
    public static void main(String[] args) {
        System.out.println(averageWaitingTime(new int[][]{{5,2},{5,4},{10,3},{20,1}}));
    }
    public static double averageWaitingTime(int[][] customers) {
        int start = customers[0][0]+customers[0][1];
        double sum = start - customers[0][0]; 

        for (int i = 1; i < customers.length; i++) {
            if (customers[i][0]>start){
                start = customers[i][1] + customers[i][0];
                sum +=start- customers[i][0];
                
            }
            else{
                start +=customers[i][1];
                sum += start-customers[i][0];
            }
        }
        return (double) sum/customers.length;
    }
}
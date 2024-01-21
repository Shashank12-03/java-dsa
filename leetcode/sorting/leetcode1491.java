package sorting;
import java.util.Arrays;

public class leetcode1491 {
    public static void main(String[] args) {
		int[] arr={48000,59000,99000,13000,78000,45000,31000,17000,39000,37000,93000,77000,33000,28000,4000,54000,67000,6000,1000,11000};
		System.out.println(average(arr));
	}
	public static double average(int[] salary) {
        Arrays.sort(salary);
        double sum=0;
        int n=salary.length;
        for(int i=1;i<n-1;i++){
            sum+=salary[i];
        }
        double  ans= sum/(n-2);
        return ans;
    }
}

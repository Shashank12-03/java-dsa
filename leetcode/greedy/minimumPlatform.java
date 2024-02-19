package greedy;
import java.util.*;
public class minimumPlatform {
    public static void main(String[] args) {
        System.out.println(findPlatform(new int[]{900, 940, 950, 1100, 1500, 1800},new int[]{910, 1200, 1120, 1130, 1900, 2000}, 6));
    }
    public static int findPlatform(int arr[], int dep[], int n){
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0,j=0;
        int platform=0;
        int result=1;
        while (i<n && j<n) {
            if(arr[i]<=dep[j]){
                platform++;
                i++;
            }
            else if (arr[i]>dep[j]) {
                platform--;
                j++;
            }
            if (platform>result) {
                result=platform;
            }
        }
        return result;
    }
}

package greedy;

import java.util.Arrays;

public class leetcode881 {
    public static void main(String[] args) {
        leetcode881 sol = new leetcode881();
        System.out.println(sol.numRescueBoats(new int[]{7,2,7}, 7));
    }
    
    public int numRescueBoats(int[] people, int limit) {
        int weight = 0;
        for(int wei:people){
            weight+=wei;
        }
        if (weight<=limit){
            return 1;
        }
        Arrays.sort(people);
        int start = 0;
        int end = people.length-1;
        int boat = 0;
        while(start<end){
            if (people[end]==limit){
                end--;
                boat++;
            }
            else{
                if(people[start]+people[end]==limit){
                    start++;
                    end--;
                }
                else if (people[start]+people[end] >limit){
                    end--;
                }
                else{
                    start++;
                    end--;
                }
                boat++;
            }
            if(start == end && people[end] <= limit ){
                boat++;
                return boat;
            }
        }
        return boat;
    }
}

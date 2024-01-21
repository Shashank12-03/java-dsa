package binarysearch;

public class leetcode881 {
    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{3,2,2,1}, 3));
    }
    static int numRescueBoats(int[] people, int limit) {
        int count=0;
        int sum=0;
        int max=0;
        for(int i=0;i<people.length;i++){
            sum+=people[i];
            max=Math.max(people[i],max);
        }
        if(sum==limit){
            count=people.length;
        }
        int start=max;
        int end=sum;
        while(start<end){
            if(inlimit(people,limit)){
                count++;
                end--;
            }
            else{
                start++;
            }
        }
        return count;
    }
    static boolean inlimit(int[] people, int limit){
        int sum=0;
        for(int i=0;i<people.length;i++){
            if(people[i]+sum>limit){
                sum=people[i];
            }
            else{
                sum+=people[i];
            }
        }
        return sum<=limit;
    }
}

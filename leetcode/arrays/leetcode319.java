package arrays;

// package arrays;
/*
 * 
First, we need to figure out how do we know if the ith light is on or off at the end.
it dpends on how many numbers could output i after you get product of them.
for example 6,
we will toggle the 6th light in the first round becasue 1 times6=6
we will toggle the 6th light in the second round because 2 times 3=6;
we will toggle the 6th light in third round beacuse 3 times 2 =6;
and we will toggle the 6th light in 6th round beacuse 6 times 1=6;

so since wil have 1,2,3,6,totally four numbers, we will toggle the 6th light 4 times.
and since 4 is even ,so the 6th light will be off at the end.

and for example, 9 could have division 1,3,9, there are three of them. which is odd, so the 9th light is on at the end.

then the problem is to figure out which number have odd divisions, which have even.

then, we should realize that, for no-square number, the divisions can be paired.

for example, for 6, 1,and 6 is a pair, 2 and 3 is a pair.
however, for square number, for example 9, 3 will pair by itself, or we could say, 3 does not have a partener to build a pair.

so, only lights at square numbers position will be on at the end.

so, if we have 10 lights, at the end, only 1,4,9 light will be on.

and how to count them? by sqrt(10), we could get 3, which is the number of square numbers smaller than 10
 */
public class leetcode319 {
    public static void main(String[] args) {
        System.out.println(bulbSwitch(3));
    }
    static public int bulbSwitch(int n) {
        //Bruth force
        // if(n==0){
        //     return 0;
        // }
        // boolean[] temp=new boolean[n];
        // convert(temp);
        // int count=0;
        // int j=2;
        // while(j<=n){
        //     for(int i=(1*j)-1;i<n;i+=j){
        //         if(temp[i]==true){
        //             temp[i]=false;
        //         }
        //         else{
        //             temp[i]=true;
        //         }
        //     }
        //     j++;
        // }
        // for(int i=0;i<n;i++){
        //     if(temp[i]==true){
        //         count++;
        //     }
        // }
        // return count;
        return (int) Math.sqrt(n);
    }
    // static void convert(boolean[] temp){
    //     for(int i=0;i<temp.length;i++){
    //         temp[i]=true;
    //     }
    // }
}

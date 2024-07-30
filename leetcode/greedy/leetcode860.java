package greedy;

// import java.util.*;

public class leetcode860 {
    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5,5,5,5,20,20,5,5,5,5}));
    }
    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill: bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                ten++;
                if (five == 0) {
                    return false;
                } else {
                    five--;
                }
            } else if (bill == 20) {
                if (ten == 0) {
                    if (five < 3) {
                        return false;
                    }
                    five = five - 3;
                } else {
                    ten--;
                    if (five == 0) {
                        return false;
                    }
                    five--;
                }
            }
        }
        return true;
        // int five = 0;
        // int ten = 0;
        // int twenty = 0;
        // for (int i = 0; i < bills.length; i++) {
        //     if (bills[i]==5){
        //         five++;
        //     }
        //     if (bills[i]==10){
        //         ten++;
        //         if(five>0){
        //             five--;
        //         }
        //     }
        //     if (bills[i]==20){
        //         twenty++;
        //         if(five>0 && ten>0){
        //             five--;
        //             ten--;
        //         }
        //         else if(five>2){
        //             five -=3;
        //         }
        //     }
        // }
        // int require = 5*bills.length;
        // int total  = 5*five + 10*ten + 20*twenty;
        // return require==total;
    }
}

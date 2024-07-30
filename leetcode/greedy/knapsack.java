package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class knapsack {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{1,2,3,4,7}));
    }
    public double fractionalKnapsack(int w, Item arr[], int n) {
        // Your code here
        double totalWeight = 0;
        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                double r1 = (double)a.value / a.weight;
                double r2 = (double)b.value / b.weight;
                return Double.compare(r2, r1); // Sort in descending order
            }
        });
        for(int i =0;i<arr.length;i++){
            if(w>arr[i].weight){
                totalWeight+=arr[i].value;
                w-=arr[i].weight;
            }else if(w<arr[i].weight){
                totalWeight+= w*(arr[i].value/arr[i].weight);
                w=0;
            }
        }
        return totalWeight;
    }
    public static int solve(int bt[] ) {
        // code here
        // 1 2 3 4 7    
        Arrays.sort(bt);
        int wtTime =0;
        int t = 0;
        for(int i =0;i<bt.length-1;i++){
            wtTime+=t;
            t+=bt[i];
        }
        return wtTime/bt.length;
    }
}

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
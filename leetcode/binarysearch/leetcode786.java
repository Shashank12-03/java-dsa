package binarysearch;

import java.util.*;
public class leetcode786 {

    public static void main(String[] args) {
        leetcode786 sol = new leetcode786();
        System.out.println(Arrays.toString(sol.kthSmallestPrimeFraction(new int[]{1,2,3,5}, 3)));
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            double valueA = (double) a.numer / a.denor;
            double valueB = (double) b.numer / b.denor;
            return Double.compare(valueA, valueB);
        });
        for(int i = 0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                pq.add(new Pair(arr[i] ,arr[j]));
            }
        }
        int numer = 0;
        int denom = 0;
        while(!pq.isEmpty() && k>0){
            Pair ans = pq.poll();
            numer = ans.numer;
            denom = ans.denor;
            k--;
        }
        
        return new int[]{numer,denom};
    }
}

class  Pair {
    int numer;
    int denor;
    double val;
    Pair(int numer,int denor){
        this.numer = numer;
        this.denor = denor;
    }
}
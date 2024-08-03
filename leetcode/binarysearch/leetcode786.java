package binarysearch;

import java.util.*;
public class leetcode786 {
    static class  Pair {
        int numer;
        // int numInd;
        int denor;
        // int denInd;
        double val;
        Pair(int numer,int denor){
            this.numer = numer;
            // this.numInd = numInd;
            this.denor = denor;
            // this.denInd = denInd;
            this.val =(double) numer/denor;
            System.out.println(this.numer + " " + this.denor + " " + this.val );
        }
    }

    static class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            return Double.compare(p1.val, p2.val);
        }
    }

    public static void main(String[] args) {
        leetcode786 sol = new leetcode786();

        System.out.println(Arrays.toString(sol.kthSmallestPrimeFraction(new int[]{1,2,3,5}, 3)));
    }
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        // Map<Integer,int[]> map = new HashMap<>();
        List<Pair> list = new ArrayList<>(); 
        for(int i = 0;i<arr.length;i++){
            for(int j=arr.length-1;j>i;j--){
                list.add(new Pair(arr[i] ,arr[j]));
            }
        }
        // int[] ans =new int[]{0,0};
        Collections.sort(list, new PairComparator());
        // System.out.println(list);
        for (Pair pair : list) {
            printPair(pair);
        }
        Pair pair = list.get(k-1);
        
        return new int[]{pair.numer,pair.denor};
    }
    public void printPair(Pair pair){
        System.out.println(pair.denor + " " + pair.numer + " " + pair.val);
    }
}
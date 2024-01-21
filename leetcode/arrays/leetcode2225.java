package arrays;
import java.util.*;
public class leetcode2225 {
    public static void main(String[] args) {
        int[][] arr={{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        List<List<Integer>> ans= findWinners(arr);
        for(List<Integer> list:ans){
            System.out.println(list);
        }
    }
    public static List<List<Integer>> findWinners(int[][] matches) {
        int[] losses = new int[100001];

        for (int i = 0; i < matches.length; i++) {
            int win = matches[i][0];
            int loss = matches[i][1];

            if (losses[win] == 0) {
                losses[win] = -1;
            } 

            if (losses[loss] == -1) {
                losses[loss] = 1;
            } else {
                losses[loss]++;
            }
        }

        List<Integer> zeroLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < losses.length; i++) {
            if (losses[i] == -1) {
                zeroLoss.add(i);
            } else if (losses[i] == 1) {
                oneLoss.add(i);
            }
        }

        result.add(zeroLoss);
        result.add(oneLoss);

        return result;
        // List<List<Integer>> ans = new ArrayList<>();
        // List<Integer> zerolost=new ArrayList<>();
        // List<Integer> onelost=new ArrayList<>();
        // HashMap<Integer,Integer> win = new HashMap<>();
        // HashMap<Integer,Integer> lost = new HashMap<>();
        // for (int i = 0; i < matches.length; i++) {
        //     win.put(matches[i][0], win.getOrDefault(matches[i][0], 0) + 1);
        //     lost.put(matches[i][1], lost.getOrDefault(matches[i][1], 0) + 1);
        // }
        // for (Map.Entry<Integer,Integer> entry : win.entrySet()) {
        //     int element=entry.getKey();
        //     if(!lost.containsKey(element)){
        //         zerolost.add(element);
        //     }
        // }
        // for (Map.Entry<Integer,Integer> entry : lost.entrySet()) {
        //     int element=entry.getKey();
        //     if(lost.get(element)==1){
        //         onelost.add(element);
        //     }
        // }

        // ans.add(zerolost);
        // ans.add(onelost);
        // return ans;
    }
}

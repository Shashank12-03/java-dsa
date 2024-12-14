package arrays;

import java.util.*;

public class contest {

    public static void main(String[] args) {
        contest sol = new contest();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(3);
        System.out.println(sol.findMinimumTime(list, 1));
    }
    public int findMinimumTime(List<Integer> strength, int K) {
        Collections.sort(strength);
        int ans = 0;
        int energy = 0;
        int power = 1;
        int i = 0;
        // 1 3 4
        while(i<strength.size()){
            if(energy>=strength.get(i)){
                energy =energy-strength.get(i);
                power+=K;
                i++;
            }
            energy+=power;
            ans++;
        }
        return ans;
    }
}
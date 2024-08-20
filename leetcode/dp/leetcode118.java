package dp;

import java.util.ArrayList;
import java.util.List;

public class leetcode118 {
    public static void main(String[] args) {
        leetcode118 sol = new leetcode118();
        System.out.println(sol.generate(3));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        ans.add(new ArrayList<>(prev));
        
            //             1
            //           1   1
            //         1   2   1
            //        1  3   3   1
            //       1 4   6   4  1
        for(int i=2;i<=numRows;i++){
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j <=prev.size(); j++) {
                if (i==2){
                    list.add(1);
                    list.add(1);
                    break;
                }else{
                    if(j==0 || j==prev.size()){
                        list.add(1);
                    }
                    else{
                        list.add(prev.get(j-1)+prev.get(j));
                    }
                }
            }
            ans.add(new ArrayList<>(list));
            prev = list; 
        }
        System.out.println(ans);
        // helper(ans,new ArrayList<>(),1,numRows);
        return ans;
        

    }
    // private void helper(List<List<Integer>> ans, List<Integer> list, int i, int numRows) {
    //     if(i==numRows){
    //         return;
    //     }
        
    // }
}

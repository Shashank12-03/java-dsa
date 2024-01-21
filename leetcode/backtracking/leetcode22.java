package backtracking;
import java.util.*;
public class leetcode22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    
    // public static List<String> generateParenthesis(int n) {
    //     LinkedList<String> ans= new LinkedList<String>();
    //     if(n<=0){
    //         return ans;
    //     }
    //     dfs(n,0,"",ans);
    //     return ans;
    // }

    // private static void dfs(int left, int right, String res, LinkedList<String> ans) {
    //     if(left==0 && right==0){
    //         ans.add(res);
    //         return;
    //     }
    //     if(left>0){
    //         dfs(left-1, right+1, res+"(", ans);
    //     }
    //     if(right>0){
    //         dfs(left, right-1, res+")", ans);
    //     }
    // }
    public static List<String> generateParenthesis(int n){
        List<String> ans= new ArrayList<>();
        if(n<=0){
            return ans;
        }
        backtracking(n,0,0,new StringBuilder(),ans);
        return ans;
    
    }
    private static void backtracking(int n, int leftcount, int rightcount, StringBuilder res, List<String> ans) {
        if(res.length()==2*n){
            ans.add(res.toString());
            return;
        }
        if(leftcount<n){
            backtracking(n, leftcount+1, rightcount, res.append("("), ans);
            res.deleteCharAt(res.length()-1);
        }
        if(rightcount<leftcount){
            backtracking(n, leftcount, rightcount+1, res.append(")"), ans);
            res.deleteCharAt(res.length()-1);
        }
    }
}

package string;
import java.util.ArrayList;
import java.util.Collections;

public class leetcode60 {
    public static void main(String[] args) {
        System.out.println(getPermutation(9,199269));
    }
    public static String getPermutation(int n, int k) {
        String topass=convert(n);
        ArrayList<String> ans=permutation("", topass);
        Collections.sort(ans);
        return ans.get(k-1);
    }
    static ArrayList<String> permutation(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch=up.charAt(0);
        ArrayList<String> ans=new ArrayList<>();
        for(int i=0;i<=p.length();i++){
            String f=p.substring(0, i);
            String s=p.substring(i, p.length());
            ans.addAll(permutation(f+ch+s, up.substring(1)));
        }
        return ans;
    }
    static String convert(int n){
        StringBuilder p=new StringBuilder("");
        for(int i=1;i<=n;i++){
            p.append(i);
        }
        return p.toString();
    }
}

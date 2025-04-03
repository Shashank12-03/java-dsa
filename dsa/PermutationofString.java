 
import java.util.*;

public class PermutationofString {
    public static void main(String[] args) {
        permutationofstring("","abc");
        ArrayList<String> ans=permutation("","abc");
        System.out.println(ans);
        System.out.println(permutationcount("","abc"));
    }
    static void permutationofstring(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String f=p.substring(0, i);
            String s=p.substring(i, p.length());
            permutationofstring(f+ch+s, up.substring(1));
        }
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
    static int permutationcount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }
        char ch=up.charAt(0);
        int count=0;
        for(int i=0;i<=p.length();i++){
            String f=p.substring(0, i);
            String s=p.substring(i, p.length());
            count+=permutationcount(f+ch+s, up.substring(1));
        }
        return count;
    }
}

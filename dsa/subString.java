import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subString {
    public static void main(String[] args) {
        //subseq("","abc");
        // System.out.println(subseqRet(" ", "abc"));
        //System.out.println(subseqAsCII(" ", "abc"));
        int[] arr={1,1,2};
        List<List<Integer>> ans= subsetRep(arr);
        for(List<Integer> list:ans){
            System.out.println(list);
        }
        // List<List<Integer>> ans= subsetRep(arr);
        // for(List<Integer> list:ans){
        //     System.out.println(list);
        // }
    }
    static void subseq(String p, String up){
        // String [] ans=new String[40];
        // int k=0;
        if(up.isEmpty()){
            System.out.println(p);
            return;
            // ans[k++]=p;
        }
        //substring divdes the string from given index
        char ch=up.charAt(0);
        subseq(p+ch, up.substring(1));
        subseq(p, up.substring(1));
    }
    static ArrayList<String> subseqRet(String p, String up){
            if(up.isEmpty()){
                ArrayList<String> list= new ArrayList<>();
                list.add(p);
                return list;
            }
            char ch=up.charAt(0);
            ArrayList<String> left=subseqRet(p+ch, up.substring(1));
            ArrayList<String> right=subseqRet(p, up.substring(1));
            left.addAll(right);
            return left;
    }
    static ArrayList<String> subseqAsCII(String p, String up){
            if(up.isEmpty()){
                ArrayList<String> list= new ArrayList<>();
                list.add(p);
                return list;
            }
            char ch=up.charAt(0);
            ArrayList<String> first=subseqAsCII(p+ch, up.substring(1));
            ArrayList<String> second=subseqAsCII(p, up.substring(1));
            ArrayList<String> third=subseqAsCII(p+(ch+0), up.substring(1));
            first.addAll(second);
            first.addAll(third);
            return first;
    }
    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer= new ArrayList<>();
        // for(int num: arr){
        //     int n=outer.size();
        //     for(int i=0;i<n;i++){
        //         List<Integer> internal =new ArrayList<>(outer.get(i));
        //         internal.add(num);
        //         outer.add(internal);
        //     }
        // }
        // return outer;
        subset(0, arr,outer, new ArrayList<>());
        return outer;
    }
    private static void subset(int index, int[] arr,List<List<Integer>> ans, List<Integer> internalans){
        if(index==arr.length){
            ans.add(new ArrayList<>(internalans));
            return;
        }
        internalans.add(arr[index]);
        subset(index+1, arr, ans,internalans);
        internalans.remove(internalans.size()-1);
        subset(index+1, arr, ans, internalans); 
    }
    static List<List<Integer>> subsetRep(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer= new ArrayList<>();
        outer.add(new ArrayList<>());
        int start=0;
        int end=0;
        for(int i=0;i<arr.length;i++){
            start=0;
            if(i>0 && arr[i]==arr[i-1]){
                start=end+1;
            }
            end=outer.size();
            int n=outer.size();
            for(int j=start;j<n;j++){
                List<Integer> internal =new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
}

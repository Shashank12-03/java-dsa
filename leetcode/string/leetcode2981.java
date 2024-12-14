package string;

public class leetcode2981 {
    public static void main(String[] args) {
        leetcode2981 sol = new leetcode2981();
        System.out.println(sol.maximumLength("aaaa"));
    }

    public int maximumLength(String s) {
        int ans = -1;
        for(int i = 0;i<s.length();i++){
            String check = s.substring(0,i+1);
            if (check.contains(String.valueOf(s.charAt(i)))){
                int len = check.length();
                int cnt = 0;
                int j = i;
                int start = i;
                while(j<s.length()){
                    String sub = s.substring(start,j+1);
                    if(check.equals(sub)){
                        cnt++;
                    }
                    if (cnt>=3){
                        ans = Math.max(ans,len);
                    }
                    start = j;
                    j+=len;
                }
            }
        }   
        return ans;
    }
}


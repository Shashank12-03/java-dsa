package arrays;

public class leetcode2491 {
    public static void main(String[] args) {
        leetcode2491 sol = new leetcode2491();
        System.out.println(sol.dividePlayers(new int[]{2,2,2,2}));
    }
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int sum = 0;
        for(int num:skill){
            sum+=num;
        }
        if( (sum*2) % n != 0){
            return -1;
        }
        int equal = (sum * 2) / n;
        int[] freq = new int[1001];
        for(int num:skill){
            freq[num]++;
        } 
        long ans = 0;
        for(int i = 1;i<1001;i++){
            while(freq[i]>0){
                int first = i;
                int second = equal-first;
                if(freq[second]>0){
                    ans+= (first*second);
                    freq[second]--;
                    freq[first]--;
                }
                else{
                    return -1;
                }
            }
        }
        return ans;
    }
}

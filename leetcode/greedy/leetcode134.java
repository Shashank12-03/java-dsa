package greedy;

public class leetcode134 {
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum=0;
        for (int num : gas) {
            gasSum+=num;
        }
        int costSum=0;
        for (int num : cost) {
            costSum+=num;
        }
        int res=0;
        if (gasSum>=costSum) {
            int total=0;
            for (int i = 0; i < cost.length; i++) {
                total+=gas[i]-cost[i];
                if (total<0) {
                    total=0;
                    res=i+1;
                }
            }
            return res;
        }else{
            return -1;
        }
    }
}

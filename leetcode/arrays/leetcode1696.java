package arrays;

public class leetcode1696 {
    public static void main(String[] args) {
        frequencySort(new int[]{1,1,2,2,2,3});
    }
    public static int[] frequencySort(int[] nums) {
        Pair[] map = new Pair[201];
        for(int i =0;i<nums.length;i++){
            if(map[nums[i]]!=null && nums[i] == map[nums[i]].num){
                map[nums[i]].frq++;
            }else{
                map[nums[i]] = new Pair(1,nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println("freq " +map[nums[i]].frq + " of num " + map[nums[i]].num );
        }
        return new int[]{};
    }
}
class Pair{
    int frq;
    int num;
    Pair(int frq,int num){
        this.frq = frq;
        this.num = num;
        System.out.println(frq+" frq "+ num+ " num");
    }
}
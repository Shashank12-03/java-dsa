public class arithmatic {
    public static void main(String[] args) {
        Isprogression(new int[]{2,4,4,16,32});
    }
    public static void Isprogression(int[]nums){
        if(nums.length<2){
            return;
        }
        int diff=nums[1]-nums[0];
        boolean arithmatic=false;
        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1]==diff){
                arithmatic=true;
            }
            else{
                break;
            }
        }
        int ratio=nums[1]/nums[0];
        boolean geometric=false;
        for(int i=2;i<nums.length;i++){
            if(nums[i]/nums[i-1]==ratio){
                geometric=true;
            }
            else{
                break;
            }
        }
        if (arithmatic) {
            System.out.println("Arithematic Progression");
        }
        if (geometric) {
            System.out.println("Geometric Progression");
        }
        else{
            System.out.println("kuch nahi");
        }
    }
}

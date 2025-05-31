package greedy;

public class leetcode1007 {
    public static void main(String[] args) {
        int[] tops = {3,5,1,2,3};
        int[] bottoms = {3,6,3,3,4};
        leetcode1007 solution = new leetcode1007();
        int result = solution.minDominoRotations(tops, bottoms);
        System.out.println("Minimum domino rotations: " + result);
    }
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int minTopFlips = n+1;
        for(int i = 1;i<6;i++){
            int topFlips = 0;
            for(int face = 0;face<n;face++){
                if(tops[face]!=i){
                    if(bottoms[face]==i){
                        topFlips++;
                    }
                    else{
                        topFlips = -1;
                        break;
                    }
                }
            }
            if(topFlips!=-1){
                minTopFlips = Math.min(minTopFlips,topFlips);
            }
        }
        int minBottomFlips = n+1;
        for(int i = 1;i<6;i++){
            int bottomFlips = 0;
            for(int face = 0;face<n;face++){
                if(bottoms[face]!=i){
                    if(tops[face]==i){
                        bottomFlips++;
                    }
                    else{
                        bottomFlips = -1;
                        break;
                    }
                }
            }
            if(bottomFlips!=-1){
                minBottomFlips = Math.min(minBottomFlips,bottomFlips);
            }
        }
        return Math.min(minBottomFlips,minTopFlips)== n+1 ? -1 : Math.min(minBottomFlips,minTopFlips);
    }
}

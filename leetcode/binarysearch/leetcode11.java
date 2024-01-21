
public class leetcode11 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    static int maxArea(int[] height) {
        int area=0;
        int maxarea=0;
        int start=0;
        int end=height.length-1;
        while(start<=end){
            int min=Math.min(height[start],height[end]);
            area=min*(end-start);
            if(area>maxarea){
                maxarea=area;
            }
            if(height[start]==height[end]){
                start++;
                end--;
            }
            else if(height[start]<height[end]){
                start++;
            }
            else if(height[start]>height[end]){
                end--;
            }
        }
         
        return maxarea;
    }
}

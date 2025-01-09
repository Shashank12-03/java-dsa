package arrays;

import java.util.Arrays;

class NumArray {
    int[] arr; 
    int ind = -1;
    int value = 0;
    int[] prefix;
    public NumArray(int[] nums) {
        arr = nums;
        prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            prefix[i] = prefix[i-1]+nums[i];
        }
        System.out.println(Arrays.toString(prefix));
    }

    public static void main(String[] args) {
        NumArray obj = new NumArray(new int[]{9, -8});
        obj.update(0, 3);
        System.out.println(obj.sumRange(1, 1)); // Output should be -8
        System.out.println(obj.sumRange(0, 1)); // Output should be -5
        obj.update(1, -3);
        System.out.println(obj.sumRange(0, 1)); // Output should be 0
    }
    
    public void update(int index, int val) {
        ind = index;
        value = val;

    }
    public int sumRange(int left, int right) {
        int leftSum = 0;
        int rightSum = 0;
        if (left==right) {
            return arr[left];
        }
        if (ind<left) {
            int diff = arr[ind] - value;
            return prefix[right] - (prefix[left] -diff);
        }
        else if(ind>=left && ind<=right){
            int diff = arr[ind] - value;
            if (left==0) {
                return prefix[right]-diff;
            }
            leftSum = prefix[ind]-prefix[left-1];
            rightSum = prefix[right] - prefix[ind+1] -diff;   
        }
        else{
            if (left==0) {
                return prefix[right];
            }
            return prefix[right] - prefix[left];
        }
        return leftSum+rightSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
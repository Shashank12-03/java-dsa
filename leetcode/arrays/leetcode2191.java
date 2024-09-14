package arrays;
import java.util.*;

public class leetcode2191 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortJumbled(new int[]{8,9,4,0,2,1,3,5,7,6}, new int[]{991,338,38})));
    }

    // public static int[] sortJumbled(int[] mapping, int[] nums) {
    //     List<Item> map = new ArrayList<>();
    //     for (int i = 0; i < nums.length; i++) {
    //         String num = Integer.toString(nums[i]);
    //         int newNum = 0;
    //         for (int j = 0; j < num.length(); j++) {
    //             int n = num.charAt(j)-'0';
    //             newNum*=10;
    //             newNum +=mapping[n];
    //         }
    //         map.add(new Item(i,nums[i], newNum));
    //     }
    //     Collections.sort(map);

    //     for (int i = 0; i < nums.length; i++) {
    //         nums[i] = map.get(i).val;
    //     }

    //     return nums;
    // }
    public static int[] sortJumbled(int[] mapping, int[] nums) {
        // this problem can be solved using the concept of Radix Sort;
        int max = -1 ;
        
        for(int x : nums)
        {
            if(x > max) max = x ;
        }  
        
        int [] ans = nums;
        
        for(int place = 1 ; max/place > 0 ; place *= 10 )   {
            ans = CountSort( ans, place , mapping);
        }
        
        return ans;
        }
    public static int[] CountSort(int [] arr , int place, int[] mapping){

        int n = arr.length;
    
        if( n <= 1 )return arr;
    
        int[] ans = new int[n];
    
        int[] freqArr = new int[10];
    
        for(int x : arr)                   // making frequency array;
        {    
            if(x/place != 0 || x==0)
            { int val = (x/place) % 10 ;
            
                freqArr[ mapping[val] ]++;        }
            else
            {
                freqArr[ 0 ]++;        
            }
        }
    
    
        for(int i = 1 ; i<10 ; i++)       // converting frequency array into prefix sum array;
        {
            freqArr[i] += freqArr[i-1];
        }
    
        for(int i = n - 1 ; i >= 0 ; i--)
        {
            if( arr[i]/place != 0 || arr[i]== 0)
            {
            int val = ( arr[i]/place )%10;
    
                ans[ freqArr[mapping[val]] - 1 ] = arr[i] ;
                
                freqArr[mapping[val]]--;
            }
            else
            {
                ans[ freqArr[0] - 1] = arr[i];
                freqArr[0]--;
            }
        }
    
        return ans;
    }
}

class Item implements Comparable <Item>{
    int pos;
    int val;
    int aftValue;

    Item(int pos, int val, int aftValue){
        this.pos = pos;
        this.val = val;
        this.aftValue = aftValue;
        System.out.println(pos +" " + val + " " + aftValue +  " ");
    }

    @Override
    public int compareTo(Item other){
        return Integer.compare(this.aftValue, other.aftValue);
    }
}
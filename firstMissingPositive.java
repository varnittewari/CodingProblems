/* Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3. */

public class firstMissingPositive {

    public static void main(String[] args){
        int[] arg = {3,4,-1,-1};
        int a = findMissingPositive(arg);
        System.out.println(a);
    }

    public static int findMissingPositive(int[] nums) {
        if (nums.length==0)
            return 1;
        int n =nums.length;
        int i=0;
        while (i<n){
            if (nums[i]==i+1)
                i++;
            else{
                if (nums[i]>n || nums[i]<=0)
                    i++;
                else{
                    if (nums[nums[i]-1]!=nums[i])
                        swap(nums, i, nums[i]-1);
                    else 
                        i++;
                }
            }
        }
        
        int max = 0;
        for (i=0; i<nums.length; i++){
            if (nums[i]!=i+1)
                return i+1;
            if (nums[i]>max)
                max = nums[i];
        }
        return max+1;
    }
    
    public static void swap(int[] nums, int m, int n){
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }
}
/* Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division? */

public class productExceptSelf{

    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(prodExcept(nums));
    }

    public static int[] prodExcept(int[] nums){
        if (nums.length==0)
            return nums;
        int[] ans = new int[nums.length];
        for (int i=0; i<nums.length; i++)
            ans[i]=1;
        
        int left=1;
        for (int i=0; i< nums.length; i++){
            ans[i] = ans[i]*left;
            left = left*nums[i];
        }
        
        int right=1;
        for(int i=nums.length-1; i>=0;i--){
            ans[i] = ans[i]*right;
            System.out.println(ans[i]);
            right = right*nums[i];
        }
        return ans;
    }
}
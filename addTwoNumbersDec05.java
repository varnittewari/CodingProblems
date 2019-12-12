
import java.util.*;

/* Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass? */
public class addTwoNumbersDec05{
    public static void main(String[] args){
        int[] arg = {10,15,3,7};
        int k = 17;
        System.out.println(addTwoNum(arg, k));
    }

    public static boolean addTwoNum(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for (int i: nums){
            if (map.containsKey(k-i))
                return true;
            else
                map.put(i,1);
        }
        return false;
    }
}

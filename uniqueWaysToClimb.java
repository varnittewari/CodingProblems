import java.util.*;

public class uniqueWaysToClimb{

    public static void main(String[] args){
        System.out.println(solution(4, new int[]{1,2,3}));
        System.out.println(solution(4, new int[]{1,2,3}));
        System.out.println(solution(4, new int[]{1,2,3}));
    }

    public static int solution(int n, int[] steps) {
        Arrays.sort(steps);
        return _countUniqueWays(n, 0, 0, steps);
    }

    private static int _countUniqueWays(int n, int cur, int res, int[] steps) {
        if (cur == n)
            res++;

        if (cur < n) {
            for (int i = 0; i < steps.length; i++)
                res = _countUniqueWays(n, cur + steps[i], res, steps);
        }

        return res;
    }
}
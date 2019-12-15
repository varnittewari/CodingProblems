public class maxNonAdjacentSum{

    public static void main(String[] args){
        System.out.println(solution(new int[] {2, 4, 6, 2, 5}));
        System.out.println(solution(new int[] {-4,-3,-1,0,-6,-10}));
        System.out.println(solution(new int[] {1,11,3,1,7,-2,1}));
    }

    public static int solution(int[] arr){
        if (arr == null || arr.length == 0)
            return 0;
        if (arr.length == 1)
            return arr[0];
        if (arr.length == 2)
            return Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            if (i > 2)
                arr[i] = Math.max(arr[i - 2], arr[i - 3]) + Math.max(0, arr[i]);
            else
                arr[i] = arr[i - 2] + Math.max(0, arr[i]);
        }

        return Math.max(arr[arr.length - 1], arr[arr.length - 2]);
    }
}
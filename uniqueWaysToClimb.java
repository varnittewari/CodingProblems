public class uniqueWaysToClimb{

    public static void main(String[] args){
        System.out.println(solution(4));
        System.out.println(solution(0));
        System.out.println(solution(8));
    }

    public static int solution(int n){
        if (n==0) return 0;
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        for (int i=2;i<n; i++){
            arr[i] = arr[i-2] + arr[i-1];
        }
        return arr[n-1];
    }
}
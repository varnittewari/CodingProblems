public class decodeAlphabets{

    public static void main(String[] args){
        String str = "1111";
        System.out.println(numDecodings(str));
    }

    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            int oneDigit = s.charAt(i-1) - '0';
            if (oneDigit > 0 && oneDigit <= 9) {
                dp[i] += dp[i-1];
            }
            if (i >= 2) {
                int twoDigit = Integer.parseInt(s.substring(i-2, i));
                if (twoDigit >= 10 && twoDigit <= 26) {
                    dp[i] += dp[i-2];
                }
            }
        }
        
        return dp[s.length()];
    }
}
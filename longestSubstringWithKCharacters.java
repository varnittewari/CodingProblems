
public class longestSubstringWithKCharacters{

    public static void main(String[] args){
        System.out.println(solution("world",8));
    }

    public static int solution(String s, int k){
        if (s.equals("")) return 0;
        int max = Integer.MIN_VALUE;
        int[] freq = new int[26];
        int i=0;
        int j=0;
        int num = 0;
        while (i<s.length() && j<s.length()){
            if (freq[s.charAt(j)-'a']==0)
                num++;
            freq[s.charAt(j)-'a']++;
            if (num>k){
                while(i<j && freq[s.charAt(i)-'a']!=1){
                    freq[s.charAt(i)-'a']--;
                    i++;
                }
                if (i!=j){
                    freq[s.charAt(i)-'a']--;
                    num--;
                    i++;
                }
            }
            max = Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}
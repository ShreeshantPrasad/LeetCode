class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;
        for(int i = num1; i <= num2; i++){
            ans += findScore(i);
        }
        return ans;
    }
    private int findScore(int num){
        String s = String.valueOf(num);
        int l = s.length();
        if(l < 3) return 0;
        int score = 0;
        for(int  i = 1; i <= l-2; i++){
            if(s.charAt(i) - '0' > s.charAt(i-1) - '0' && s.charAt(i) - '0' > s.charAt(i+1) - '0') score++;
            if(s.charAt(i) - '0' < s.charAt(i-1) - '0' && s.charAt(i) - '0' < s.charAt(i+1) - '0') score++;
        }
        return score;
        
    }
}
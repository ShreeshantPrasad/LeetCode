class Solution {
    public int numberOfSubstrings(String s) {
        int [] cnt = new int[3];
        int ans = 0;
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            cnt[s.charAt(r) - 'a']++;
            while(cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0){
                ans += s.length() - r;
                cnt[s.charAt(l++) - 'a']--;
            }
        }
        return ans;
    }
}
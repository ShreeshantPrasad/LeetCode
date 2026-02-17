class Solution {
    public int characterReplacement(String s, int k) {
        int [] arr = new int[26];
        int ans = 0;
        int max = 0;
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            arr[s.charAt(r)-'A']++;
            max = Math.max(max, arr[s.charAt(r)-'A']);
            int len = r - l + 1;
            if(len - max > k){
                arr[s.charAt(l)-'A']--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
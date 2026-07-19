class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        boolean [] vis = new boolean[26];
        int [] lastIdx = new int[26];
        Arrays.fill(lastIdx, -1);

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            lastIdx[ch - 'a'] = i;
        }
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            int idx = ch - 'a';
            if(vis[idx] == true) continue;
            while(ans.length() > 0 && ans.charAt(ans.length() - 1) > ch && lastIdx[ans.charAt(ans.length() - 1) - 'a'] > i){
                vis[ans.charAt(ans.length() - 1) - 'a'] = false;
                ans.deleteCharAt(ans.length() - 1);
            }
            ans.append(ch);
            vis[idx] = true;
        }
        return ans.toString();
    }
}
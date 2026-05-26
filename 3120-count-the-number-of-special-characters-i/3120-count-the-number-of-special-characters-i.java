class Solution {
    public int numberOfSpecialChars(String word) {
        boolean [] vis = new boolean[26];
        for(char ch : word.toCharArray()){
            if(ch >= 'a' && ch <= 'z'){
                vis[ch - 'a'] = true;
            }
        }
        int cnt = 0;
        for(char ch : word.toCharArray()){
            if(ch >= 'A' && ch <= 'Z'){
                if(vis[ch - 'A']){
                    vis[ch - 'A'] = false;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
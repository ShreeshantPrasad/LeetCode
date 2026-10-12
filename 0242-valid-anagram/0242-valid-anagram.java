class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int [] sl = new int[26];
        int [] tl = new int[26];
        for(int i = 0; i < s.length(); i++){
            sl[s.charAt(i) - 'a']++;
            tl[t.charAt(i) - 'a']++;
        }
        return Arrays.equals(sl, tl);
    }
}
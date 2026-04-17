class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int n = s.length();
        int [] sArr = new int[27];
        int [] tArr = new int[27];
        for(int i = 0; i < n; i++){
            sArr[s.charAt(i) - 'a']++;
            tArr[t.charAt(i) - 'a']++;
        }
        return Arrays.equals(sArr,tArr);
    }
}
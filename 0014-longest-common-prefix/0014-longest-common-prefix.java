class Solution {
    public String longestCommonPrefix(String[] strs) {
        String pref = strs[0];
        int len = pref.length();
        for(int i = 0; i < strs.length; i++){
            String curr = strs[i];
            while(len > curr.length() || !pref.equals(curr.substring(0,len))){
                len--;
                if(len == 0) return "";
                pref = pref.substring(0, len);
            }
        } 
        return pref;
    }
}
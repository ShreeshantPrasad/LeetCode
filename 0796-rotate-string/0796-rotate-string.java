class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;
        int n = s.length();
        String s2 = s + "" + s;
        for(int i = 0; i < n; i++){
            if(goal.equals(s2.substring(i, i + n))) return true;
        }
        return false;
    }
}
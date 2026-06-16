class Solution {
    public String processStr(String s) {
        StringBuilder ans = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == '*'){
                if(ans.length() > 0) ans.deleteCharAt(ans.length() - 1);
            }
            else if( ch == '#'){
                ans.append(ans.toString());
            }
            else if( ch == '%'){
                ans.reverse();
            }
            else{
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}
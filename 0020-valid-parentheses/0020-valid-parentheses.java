class Solution {
    public boolean isValid(String s) {
        int prevLength=-1;
        while(s.length()!=prevLength){
            prevLength=s.length();
            s=s.replace("()", "")
               .replace("{}", "")
               .replace("[]", "");

        }
        return s.length()==0;
        
    }
}
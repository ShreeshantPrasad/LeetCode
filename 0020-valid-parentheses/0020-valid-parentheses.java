class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '['){
                stk.push(ch);
            }
            else{
                if(!stk.isEmpty()){
                    char top = stk.peek();
                    if(matches(top,ch)){
                        stk.pop();
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
        }
        if(stk.isEmpty()) return true;
        return false;  
    }

    private boolean matches(char top,char ch){
        if(ch==')' && top=='(' ||
        ch=='}' && top=='{' ||
        ch==']' && top=='['){
            return true;
        }
        return false;
    }
}
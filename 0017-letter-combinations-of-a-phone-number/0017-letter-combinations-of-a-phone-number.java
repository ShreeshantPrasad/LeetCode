class Solution {
    HashMap<Character,String> map;
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> ans = new ArrayList<>();
        solve(digits, 0, "",ans);

        return ans;
    }
    private void solve(String digits, int i, String temp, List<String> ans){
        if(i == digits.length()){
            ans.add(temp);
            return;
        } 
        for(char ch : map.get(digits.charAt(i)).toCharArray()){
            solve(digits,i+1,temp+ch,ans);
        }
        
    }
}
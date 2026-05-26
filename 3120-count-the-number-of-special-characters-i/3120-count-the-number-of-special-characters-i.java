class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> set = new HashSet<>();
        for(char ch : word.toCharArray()){
            if(ch >= 'a' && ch <= 'z'){
                set.add((char) (ch-32));
            }
        }
        int cnt = 0;
        for(char ch : word.toCharArray()){
            if(ch >= 'A' && ch <= 'Z'){
                if(set.contains(ch)){
                    set.remove(ch);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
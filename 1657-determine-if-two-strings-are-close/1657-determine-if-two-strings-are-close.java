class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        for(int i=0;i<word1.length();i++){
            set1.add(word1.charAt(i));
            set2.add(word2.charAt(i));
        }
        for(char ch : word2.toCharArray()){
            if(!set1.contains(ch)) return false;
        }
        for(char ch : word1.toCharArray()){
            if(!set2.contains(ch)) return false;
        }
        return true;
    }
}
class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String ans = "";
        HashMap<Integer,Character> map = new HashMap<>();
        char chr = 'a';
        for(int i = 25; i>=-1; i--){
            map.put(i,chr);
            chr++;
        }
        for(String word : words){
            char[] curr = word.toCharArray();
            int weight  = 0;
            for(char ch : curr){
                weight += weights[ch - 'a'];
            }
            
            weight %= 26;
            ans  += map.get(weight);
        }
        return ans;
    }
}
class Solution {
    public int maxNumberOfBalloons(String text) {
        String b = "balloon";
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(char ch : text.toCharArray()){
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        for(char ch : b.toCharArray()){
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }

        int min = Integer.MAX_VALUE;
        for(char ch : map2.keySet()){
            if(!map1.containsKey(ch)) return 0;
            int curr = map1.get(ch) / map2.get(ch);
            min = Math.min(curr,min);
        }
        return min;
    }
}
class Solution {
    public int maxVowels(String s, int k) {
        int left = 0;
        HashSet<Character> set = new HashSet<>();
        set.add('a'); set.add('e'); set.add('i'); set.add('o'); set.add('u');
        int count = 0;
        int maxC = 0;
        for(int i = 0; i < k; i++){
            if(set.contains(s.charAt(i))) count++;
        }
        maxC = Math.max(maxC, count);
        for(int right = k; right < s.length(); right++){
            if(set.contains(s.charAt(left)) ){
                count = (set.contains(s.charAt(right))) ? count : count - 1;
            }
            else{
                count = (set.contains(s.charAt(right))) ? count + 1 : count;
            }
            left++;
            maxC = Math.max(maxC, count);
        }
        return maxC;
    }
}
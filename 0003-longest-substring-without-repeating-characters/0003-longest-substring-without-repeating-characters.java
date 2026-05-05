class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        char [] arr = s.toCharArray();
        int start =0;
        int max =0;
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                start = Math.max(start,map.get(arr[i])+1);
            }
            map.put(arr[i],i);
            max = Math.max(max,i-start+1);
        }
        return max;
    }
}
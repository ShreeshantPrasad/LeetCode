class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> pMap = new HashMap<>();
        HashMap<Character,Integer> sMap = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        int start = 0;
        for(char ch : p.toCharArray()){
            pMap.put(ch, pMap.getOrDefault(ch,0)+1);
        }
        for(int i = 0; i<s.length(); i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i),0)+1);
            if(i >= p.length()-1){
                if(sMap.equals(pMap)){
                    res.add(start);
                }
                if(sMap.containsKey(s.charAt(start))){
                    sMap.put(s.charAt(start), sMap.get(s.charAt(start))-1);
                    if(sMap.get(s.charAt(start)) == 0){
                        sMap.remove(s.charAt(start));
                    }
                }
                start++;
            }
        }
        return res;
        


    }
}
//your non hindu firends are going for ramzan are going back to home state for festival , and there's a tight deadline , will you. allow ,make them stya, or do their work.
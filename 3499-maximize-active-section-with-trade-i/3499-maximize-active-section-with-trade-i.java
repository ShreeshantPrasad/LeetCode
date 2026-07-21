class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int active = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i)== '1') active++;
        }
        List<Integer> list = new ArrayList<>();
        int i = 0;

        while(i < n){
            if(s.charAt(i) == '0'){
                int start = i;
                while(i < n && s.charAt(i) == '0'){
                    i++;
                }
                list.add(i-start);
            }else{
                i++;
            }
        }
        int maxPair = 0;
        for(int j = 0; j < list.size()-1; j++){
            maxPair = Math.max(maxPair, list.get(j) + list.get(j+1));
        } 
        return maxPair + active;
    }
}
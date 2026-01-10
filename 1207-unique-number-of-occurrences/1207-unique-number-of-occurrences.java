class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        HashMap<Integer,Integer> checker = new HashMap<>();
        for(int val : map.keySet()){
            checker.put(map.get(val),checker.getOrDefault(map.get(val),0)+1);
        }
        for(int val : checker.keySet()){
            if(checker.get(val) > 1) return false;
        }
        return true;
    }
}
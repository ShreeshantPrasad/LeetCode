class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones){
            maxHeap.add(i);
        }
        while(maxHeap.size()>1){
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if(y != x){
                maxHeap.add(x-y);
            }
        }
        if(!maxHeap.isEmpty()){
            return maxHeap.poll();
        }

        return 0;
    }
}
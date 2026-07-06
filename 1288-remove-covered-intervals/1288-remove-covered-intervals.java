class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;

        Arrays.sort(intervals, (a,b) -> {
            if(a[0] == b[0]){
                return Integer.compare(b[1],a[1]);
            }
            return Integer.compare(a[0],b[0]);
        });
        res.add(intervals[0]);
        for(int i = 1; i < n; i++){
            if(res.get(res.size() - 1)[0] <= intervals[i][0] && res.get(res.size() - 1)[1] >= intervals[i][1]){
                continue;
            }
            res.add(intervals[i]);
        }
        return res.size();

    }
}
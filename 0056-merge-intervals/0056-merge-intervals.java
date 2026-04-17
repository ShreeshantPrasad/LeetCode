class Solution {
    public int[][] merge(int[][] arr) {
        int n = arr.length;
        if (n==0) return new int[0][0];
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        List<int[]> ans = new ArrayList<>();

        for (int i=0; i<n; i++) {
            if (ans.isEmpty() || arr[i][0]>ans.get(ans.size()-1)[1]){
                ans.add(new int[]{arr[i][0], arr[i][1]});
            } else{
                ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1], arr[i][1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}

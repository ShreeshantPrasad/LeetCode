class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indeg = new int[n + 1];
        int[] outdeg = new int[n + 1];
        for (int[] arr : trust) {
            indeg[arr[1]]++;
            outdeg[arr[0]]++;
        }
        for (int i = 1; i < n + 1; i++)
            if (indeg[i] == n - 1 && outdeg[i] == 0)
                return i;
        return -1;

    }
}
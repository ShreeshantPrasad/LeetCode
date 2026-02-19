class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);
        int n = s.length;
        int m = g.length;
        int i = 0, j = 0;
        while(i<n && j<m){
            if(s[i] >= g[j]){
                j++;
            }
            i++;
        }
        return j;
    }
}
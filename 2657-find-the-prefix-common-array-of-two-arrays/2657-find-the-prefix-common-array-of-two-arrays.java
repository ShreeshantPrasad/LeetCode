class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int [] common = new int[n];
        boolean [] vis = new boolean[n+1];
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(A[i] == B[i]){
                cnt++;
                common[i] = cnt;
            }
            else{
                if(vis[B[i]]) cnt++;
                if(vis[A[i]]) cnt++;
                common[i] = cnt;
            }
            vis[A[i]] = true;
            vis[B[i]] = true;
        }
        return common;
        
    }
}
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int [] common = new int[n];
        HashSet<Integer> mapA = new HashSet<>();
        HashSet<Integer> mapB = new HashSet<>();
        common[0] = (A[0] == B[0]) ? 1 : 0;
        mapA.add(A[0]);
        mapB.add(B[0]);

        for(int i = 1; i < n; i++){
            mapA.add(A[i]);
            mapB.add(B[i]);

            if(A[i] == B[i]){
                common[i] = common[i-1] + 1;
            }
            else{
                common[i] = common[i-1];
                if(mapA.contains(B[i])) common[i] += 1;
                if(mapB.contains(A[i])) common[i] += 1;
            }
        }
        return common;
        
    }
}
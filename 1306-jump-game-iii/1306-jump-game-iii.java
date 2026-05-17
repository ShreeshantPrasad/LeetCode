class Solution {
    public boolean canReach(int[] arr, int start) {
        if(start < 0 || start >= arr.length || arr[start] < 0) return false;
        if(arr[start] == 0) return true;
        arr[start] = -arr[start];
        boolean op1 = canReach(arr, start + arr[start]);
        boolean op2 = canReach(arr, start - arr[start]);
        return op1 || op2;
    }
}
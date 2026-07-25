class Solution {
    public int maxProduct(int n) {
        int x1 = 0, x2 = 0;
        while(n > 0){
            int curr = n%10;
            if(curr > x1){
                x2 = x1;
                x1 = curr;
            }else if(curr <= x1 && curr > x2){
                x2 = curr;
            }
            n /= 10;
        }
        return x1*x2;
    }
}
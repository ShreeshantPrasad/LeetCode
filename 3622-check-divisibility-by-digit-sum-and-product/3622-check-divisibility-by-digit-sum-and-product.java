class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int prod = 1;
        int num = n;
        while(n > 0){
            int val = n%10;
            sum += val;
            prod *= val;
            n /= 10;
        }
        return (num % (sum+prod)) == 0; 
   }
}
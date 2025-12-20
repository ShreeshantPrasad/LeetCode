class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1))return "";
        int val = gcd(str1.length(),str2.length());
        return str1.substring(0,val);
    }
    public int gcd(int s1, int s2){
        if(s2 == 0) return s1;
        return gcd(s2 , s1 % s2);
    }
}
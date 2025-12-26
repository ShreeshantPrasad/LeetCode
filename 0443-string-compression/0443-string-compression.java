class Solution {
    public int compress(char[] chars) {
        int i=0;
        int ansIdx =0;
        int n=chars.length;
        while(i<n){
            int j=i+1;
            while(j<n && chars[i]==chars[j]) j++;
            chars[ansIdx++] = chars[i];
            int count = j-i;
            if(count>1){
                String cnt = String.valueOf(count);
                for(char ch : cnt.toCharArray()){
                    chars[ansIdx++] = ch;
                }
            }
            i=j;
        }
        return ansIdx;
        
    }
}
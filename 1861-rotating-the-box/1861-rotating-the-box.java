class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char [][] ans = new char[n][m];

        for(int i =0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans[i][j] = box[j][i];
            }
        }
        for(char [] arr : ans){
            reverse(arr);
        }

        for(int j = 0; j < m; j++){
            for(int i = n-1; i >= 0; i--){
                if(ans[i][j] == '.'){
                    int stone = -1;
                    for(int k = i-1; k >= 0; k--){
                        if(ans[k][j] == '*'){
                            break;
                        }
                        else if(ans[k][j] == '#'){
                            stone = k;
                            break;
                        }
                    }
                    if(stone != -1){
                        ans[i][j] = '#';
                        ans[stone][j] = '.';
                    }
                }
            }
        }
        return ans;
    }
    void reverse(char[] arr){
        int l = 0, r = arr.length - 1;
        while(l < r){
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
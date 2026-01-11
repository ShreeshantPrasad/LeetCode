class Solution {
    private int[] prevSmallerElement(int[] arr,int n){
        Stack<Integer> s = new Stack<>();
        s.push(-1);

        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            int curr = arr[i];
            while(s.peek() != -1 && arr[s.peek()]>=curr){
                s.pop();
            }
            ans[i] = s.peek();
            s.push(i);
        }
        return ans;
    } 
    private int[] nextSmallerElement(int[] arr,int n){
        Stack<Integer> s = new Stack<>();
        s.push(-1);

        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--){
            int curr = arr[i];
            while(s.peek() != -1 && arr[s.peek()]>=curr){
                s.pop();
            }
            ans[i] = s.peek();
            s.push(i);
        }
        return ans;
    } 
    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] next = new int[n];
        next = nextSmallerElement(heights,n);

        int[] prev = new int[n];
        prev = prevSmallerElement(heights,n);
        int area = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int l=heights[i];
            if(next[i]== -1 ) next[i]=n;
            int b=next[i]-prev[i]-1;
            int currArea=l*b;
            area = Math.max(area,currArea);
        }
        return area;
    }
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] heights = new int[col];
        int area=0;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j] == '1'){
                    heights[j] += 1;
                }else{
                    heights[j] = 0;
                }
            }
            area = Math.max(area,largestRectangleArea(heights));
        }
        return area;
    }
}
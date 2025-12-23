class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });

        int n = envelopes.length;
        int[] height = new int[n];
        
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }

        return lis(height);
    }
    
    public int lis(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
            } else {
                temp.set(lowerBound(temp, nums[i]), nums[i]);
            }
        }

        return temp.size();
    }

    public int lowerBound(ArrayList<Integer> temp, int target) {
        int i = 0;
        int j = temp.size() - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (temp.get(mid) == target) return mid;
            else if (temp.get(mid) > target) j = mid - 1;
            else i = mid + 1;
        }

        return i;
    }
}
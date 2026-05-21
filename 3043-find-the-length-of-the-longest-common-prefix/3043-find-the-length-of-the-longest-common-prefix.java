class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            String str = String.valueOf(arr1[i]);

            for (int j = 0; j < str.length(); j++) {
                String sub = str.substring(0, j + 1);
                set.add(Integer.parseInt(sub));
            }
        }

        int count = 0;
        
        for (int i = 0; i < arr2.length; i++) {
            String str = String.valueOf(arr2[i]);

            for (int j = 0; j < str.length(); j++) {
                String sub = str.substring(0, j + 1);
                if (set.contains(Integer.parseInt(sub)))
                    count = Math.max(count, sub.length());
            }
        }

        return count;
    }
}
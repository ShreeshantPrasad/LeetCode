class Solution {
    public int bestClosingTime(String customers) {
        int pen = 0;
        for (char c : customers.toCharArray())
            if (c == 'Y') pen++;

        int best = pen;
        int ans = 0;

        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') pen--;
            else pen++;

            if (pen < best) {
                best = pen;
                ans = i + 1;
            }
        }
        return ans;
    }
}
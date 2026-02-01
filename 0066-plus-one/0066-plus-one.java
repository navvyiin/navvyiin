class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse from the least significant digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // If we reach here, all digits were 9
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}
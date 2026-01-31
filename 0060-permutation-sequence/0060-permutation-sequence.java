import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] fact = new int[n + 1];

        // Precompute factorials
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
            numbers.add(i);
        }

        // Convert k to 0-based index
        k--;

        StringBuilder result = new StringBuilder();

        for (int i = n; i >= 1; i--) {
            int idx = k / fact[i - 1];
            result.append(numbers.get(idx));
            numbers.remove(idx);
            k %= fact[i - 1];
        }

        return result.toString();
    }
}
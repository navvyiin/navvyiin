class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] answer = new int[n];

        // First pass: left to right
        int lastSeen = -n;  // acts like negative infinity
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                lastSeen = i;
            }
            answer[i] = i - lastSeen;
        }

        // Second pass: right to left
        lastSeen = 2 * n;   // acts like positive infinity
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                lastSeen = i;
            }
            answer[i] = Math.min(answer[i], lastSeen - i);
        }

        return answer;
    }
}
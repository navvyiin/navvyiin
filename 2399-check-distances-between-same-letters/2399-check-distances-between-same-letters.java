class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] firstIndex = new int[26];

        // initialise with -1 to mark unseen characters
        for (int i = 0; i < 26; i++) {
            firstIndex[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';

            if (firstIndex[ch] == -1) {
                // first occurrence
                firstIndex[ch] = i;
            } else {
                // second occurrence
                int actualDistance = i - firstIndex[ch] - 1;
                if (actualDistance != distance[ch]) {
                    return false;
                }
            }
        }

        return true;
    }
}
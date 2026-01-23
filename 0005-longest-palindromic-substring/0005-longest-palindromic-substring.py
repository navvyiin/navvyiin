class Solution:
    def longestPalindrome(self, s: str) -> str:
        if len(s) <= 1:
            return s

        start = 0
        max_len = 1

        def expand(left: int, right: int):
            nonlocal start, max_len
            while left >= 0 and right < len(s) and s[left] == s[right]:
                current_len = right - left + 1
                if current_len > max_len:
                    max_len = current_len
                    start = left
                left -= 1
                right += 1

        for i in range(len(s)):
            # Odd-length palindromes
            expand(i, i)
            # Even-length palindromes
            expand(i, i + 1)

        return s[start:start + max_len]
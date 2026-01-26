from collections import Counter, defaultdict

class Solution:
    def findSubstring(self, s: str, words):
        if not s or not words:
            return []

        word_len = len(words[0])
        word_count = len(words)
        window_len = word_len * word_count
        n = len(s)

        word_freq = Counter(words)
        result = []

        # We try each possible alignment
        for i in range(word_len):
            left = i
            current_count = 0
            seen = defaultdict(int)

            for right in range(i, n - word_len + 1, word_len):
                word = s[right:right + word_len]

                if word in word_freq:
                    seen[word] += 1
                    current_count += 1

                    # Too many occurrences — shrink window
                    while seen[word] > word_freq[word]:
                        left_word = s[left:left + word_len]
                        seen[left_word] -= 1
                        left += word_len
                        current_count -= 1

                    # Valid window
                    if current_count == word_count:
                        result.append(left)

                else:
                    # Reset window
                    seen.clear()
                    current_count = 0
                    left = right + word_len

        return result
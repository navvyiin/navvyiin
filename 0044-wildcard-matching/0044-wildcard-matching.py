class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        i = j = 0          # pointers for s and p
        star = -1          # last '*' position in p
        match = 0          # position in s when '*' was found

        while i < len(s):
            # direct match or '?'
            if j < len(p) and (p[j] == s[i] or p[j] == '?'):
                i += 1
                j += 1

            # '*' found
            elif j < len(p) and p[j] == '*':
                star = j
                match = i
                j += 1

            # mismatch but we saw a '*'
            elif star != -1:
                j = star + 1
                match += 1
                i = match

            # mismatch and no '*'
            else:
                return False

        # remaining pattern must be all '*'
        while j < len(p) and p[j] == '*':
            j += 1

        return j == len(p)
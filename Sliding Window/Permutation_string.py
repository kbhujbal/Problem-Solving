def permutation_string(s1, s2):
    len1, len2 = len(s1), len(s2)

    if len1 > len2:
        return False
    
    s1_counts = [0] * 26
    window_counts = [0] * 26

    def char_index(char):
        return ord(char) - ord('a')
    
    for i in range(len1):
        s1_counts[char_index(s1[i])] += 1
        window_counts[char_index(s2[i])] += 1
    
    if s1_counts == window_counts:
        return True
    
    for i in range(len1, len2):
        window_counts[char_index(s2[i])] += 1
        window_counts[char_index(s2[i - len1])] -= 1
    
        if s1_counts == window_counts:
            return True

    return False
    


s1 = "ab"
s2 = "eidbaooo"
print(permutation_string(s1, s2))
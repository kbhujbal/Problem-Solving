# The simplest solution is to use "".join()
# But that is not optimal because it uses O(n) extra space to build two new strings


def check_strings_equvivalent(word1, word2):
    w1_ptr = 0
    w2_ptr = 0

    c1_ptr = 0
    c2_ptr = 0

    while w1_ptr < len(word1) and w2_ptr < len(word2):
        if word1[w1_ptr][c1_ptr] != word2[w2_ptr][c2_ptr]:
            return False
        
        c1_ptr += 1
        c2_ptr += 1

        if c1_ptr == len(word1[w1_ptr]):
            w1_ptr += 1
            c1_ptr = 0
        
        if c2_ptr == len(word2[w2_ptr]):
            w2_ptr += 1
            c2_ptr = 0
        
    return w1_ptr == len(word1) and w2_ptr == len(word2)



word1 = ["ab", "c"]
word2 = ["a", "bc"]
print(check_strings_equvivalent(word1, word2))
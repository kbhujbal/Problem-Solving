def merge_string_alternatively(word1, word2):
    i, j = 0, 0

    len_1 = len(word1)
    len_2 = len(word2)

    ans = []

    while i < len_1 and j < len_2:
        ans.append(word1[i])
        ans.append(word2[j])

        i += 1
        j += 1
    
    if i != len_1:
        while i != len_1:
            ans.append(word1[i])
            i += 1
    
    if j != len_2:
        while j != len_2:
            ans.append(word2[j])
            j += 1

    
    return "".join(ans)


word1 = "abc"
word2 = "pqr"
print(merge_string_alternatively(word1, word2))
def valid_word_abbreviation(word, abbr):
    i, j = 0, 0

    len_w = len(word)
    len_a = len(abbr)

    while i < len_w and j < len_a:
        if abbr[j].isalpha():
            if word[i] != abbr[j]:
                return False
            i += 1
            j += 1
        else:
            if abbr[j] == '0':
                return False
            
            skip_count = 0
            while j < len_a and abbr[j].isdigit():
                skip_count = skip_count * 10 + int(abbr[j])
                j += 1

            i += skip_count

    return i == len_w and j == len_a 




word = "substitution"
abbr = "s10n"
print(valid_word_abbreviation(word, abbr))
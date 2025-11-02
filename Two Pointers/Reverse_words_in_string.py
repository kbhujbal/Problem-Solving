def reverse_words_in_string(s):
    words = s.split()

    reversed_words_list = []

    for word in words:
        reversed_word = word[::-1]
        reversed_words_list.append(reversed_word)

    final_string = " ".join(reversed_words_list)

    return final_string


s = "Let's take LeetCode contest"
print(reverse_words_in_string(s))
# This question on leetcode expects only to return index not the array
# Hence output of this array will be different
# Carefully read leetcode question

def string_compression(chars):
    n = len(chars)

    if n < 2:
        return n

    write_idx = 0
    read_idx = 0

    while read_idx < n:
        current_char = chars[read_idx]
        count = 0

        while read_idx < n and chars[read_idx] == current_char:
            read_idx += 1
            count += 1

        chars[write_idx] = current_char
        write_idx += 1

        if count > 1:
            for digit in str(count):
                chars[write_idx] = digit
                write_idx += 1
        

chars = ["a","a","b","b","c","c","c"]
string_compression(chars)
print(chars)
# This question on leetcode expects only to return index not the array
# Hence output of this array will be different
# Carefully read leetcode question

def string_compression(chars):
    n = len(chars)

    read_ptr = 0
    write_ptr = 0

    while read_ptr < n:
        current_char = chars[read_ptr]
        count = 0

        while read_ptr < n and chars[read_ptr] == current_char:
            read_ptr += 1
            count += 1
        
        chars[write_ptr] = current_char
        write_ptr += 1

        if count > 1:
            for digit in str(count):
                chars[write_ptr] = digit
                write_ptr += 1
        
    

chars = ["a","a","b","b","c","c","c"]
string_compression(chars)
print(chars)
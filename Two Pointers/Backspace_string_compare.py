def backspace_string_compare(s, t):
    def build_string(input_string):
        stack = []

        for char in input_string:
            if char != '#':
                stack.append(char)
            elif stack:
                stack.pop()
            
    final_s = build_string(s)
    final_t = build_string(t)

    return final_s == final_t


s = "ab#c"
t = "ad#c"
print(backspace_string_compare(s, t))
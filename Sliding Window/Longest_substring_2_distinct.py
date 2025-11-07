def longest_substring_2_distinct(s):
    if not s:
        return 0

    last_seen_index = {}

    max_len = 0
    window_start = 0

    for window_end, char in enumerate(s):
        last_seen_index[char] = window_end

        if len(last_seen_index) > 2:
            min_index = min(last_seen_index.values())

            char_to_remove = None
            for key, val in last_seen_index.items():
                if val == min_index:
                    char_to_remove = key
                    break
            
            del last_seen_index[char_to_remove]

            window_start = min_index + 1
        
        max_len = max(max_len, window_end - window_start + 1)
    
    return max_len


s = "eceba"
print(longest_substring_2_distinct(s))
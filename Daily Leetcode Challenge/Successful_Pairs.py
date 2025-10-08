import bisect

def successfulPairs(spells, potions, success):
        potions.sort()
        
        m = len(potions)
        result = []
        
        for spell in spells:
            min_potion_strength = (success + spell - 1) // spell
            
            # Use binary search to find the index of the first potion that
            # is strong enough. bisect_left finds the insertion point, which
            # corresponds to the first element >= min_potion_strength.
            first_successful_idx = bisect.bisect_left(potions, min_potion_strength)
            
            count = m - first_successful_idx
            result.append(count)
            
        return result

spells = [5, 1, 3]
potions = [1, 2, 3, 4, 5]
success = 7
ans = successfulPairs(spells, potions, success)
print(ans)
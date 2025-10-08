import bisect

def successfulPairs(spells, potions, success):
        potions.sort()
        
        m = len(potions)
        result = []
        
        for spell in spells:
            min_potion_strength = (success + spell - 1) // spell
            
            first_successful_idx = bisect.bisect_left(potions, min_potion_strength)
            
            count = m - first_successful_idx
            result.append(count)
            
        return result

spells = [5, 1, 3]
potions = [1, 2, 3, 4, 5]
success = 7
ans = successfulPairs(spells, potions, success)
print(ans)
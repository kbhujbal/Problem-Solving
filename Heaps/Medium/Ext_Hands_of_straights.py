import heapq
from collections import Counter

def findNStraightHandGroups(hand: list[int], groupSize: int) -> int:
    total_groups_formed = 0
    
    if len(hand) % groupSize != 0:
        print("Error: Total number of cards is not divisible by group size.")
        print("Grouping failed.")
        return -1
        
    card_counts = Counter(hand)
    min_heap = list(card_counts.keys())
    heapq.heapify(min_heap)
    
    print(f"--- Processing hand: {hand} with group size {groupSize} ---")
    
    while min_heap:
        start_card = heapq.heappop(min_heap)
        
        num_straights_to_form = card_counts[start_card]
        
        if num_straights_to_form == 0:
            continue
            
        for i in range(groupSize):
            current_card = start_card + i
            
            if card_counts[current_card] < num_straights_to_form:
                return -1
                
            card_counts[current_card] -= num_straights_to_form
        
        
        total_groups_formed += num_straights_to_form
        
        group_to_print = []
        for i in range(groupSize):
            group_to_print.append(start_card + i)
            
        for _ in range(num_straights_to_form):
            print(f"Formed group: {group_to_print}")

    print("\nSuccessfully grouped all cards.")
    return total_groups_formed


hand1 = [1, 2, 3, 6, 2, 3, 4, 7, 8]
groupSize1 = 3
total1 = findNStraightHandGroups(hand1, groupSize1)
print(f"Total groups formed: {total1}")

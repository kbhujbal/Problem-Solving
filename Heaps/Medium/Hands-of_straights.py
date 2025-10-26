import heapq
from typing import Counter

def isStraightHand(hand, groupSize):
    if len(hand) % groupSize != 0:
        return False
    
    card_counts = Counter(hand)

    min_heap = list(card_counts.keys())
    heapq.heapify(min_heap)

    while min_heap:
        start_card = heapq.heappop(min_heap)

        num_straights_to_form = card_counts[start_card]
        if num_straights_to_form == 0:
            continue
        
        for i in range(groupSize):
            current_card = start_card + i

            if card_counts[current_card] < num_straights_to_form:
                return False
            
            card_counts[current_card] -= num_straights_to_form
    
    return True


hand1 = [1, 2, 3, 6, 2, 3, 4, 7, 8]
groupSize1 = 3
print(isStraightHand(hand1, groupSize1))
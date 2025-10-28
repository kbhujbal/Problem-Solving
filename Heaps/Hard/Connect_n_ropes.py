import heapq

def connect_n_ropes(ropes):
    heapq.heapify(ropes)

    total_cost = 0

    while len(ropes) > 1:
        rope1 = heapq.heappop(ropes)
        rope2 = heapq.heappop(ropes)

        new_rope = rope1 + rope2 
        heapq.heappush(ropes, new_rope)
        total_cost += new_rope

    return total_cost



ropes = [4, 3, 2, 6]
print(connect_n_ropes(ropes))
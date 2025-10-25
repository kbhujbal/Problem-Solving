import heapq

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeKLists(self, lists: list[ListNode]) -> ListNode:
        min_heap = []
        
        i = 0 
        
        for head in lists:
            if head:
                heapq.heappush(min_heap, (head.val, i, head))
                i += 1
                
        dummy_head = ListNode()
        current = dummy_head
        
        while min_heap:
            val, _, smallest_node = heapq.heappop(min_heap)
            
            current.next = smallest_node
            current = current.next 
            
            if smallest_node.next:
                next_node = smallest_node.next
                heapq.heappush(min_heap, (next_node.val, i, next_node))
                i += 1
                
        return dummy_head.next


def create_list(arr: list[int]) -> ListNode:
    if not arr:
        return None
    
    dummy = ListNode()
    curr = dummy
    for val in arr:
        curr.next = ListNode(val)
        curr = curr.next
    return dummy.next

def print_list(node: ListNode):
    if not node:
        print("[]")
        return
        
    res = []
    while node:
        res.append(str(node.val))
        node = node.next
    print(" -> ".join(res))


if __name__ == "__main__":
    
    l1 = create_list([1, 4, 5])
    l2 = create_list([1, 3, 4])
    l3 = create_list([2, 6])

    lists = [l1, l2, l3]

    print("--- Input Lists ---")
    print_list(l1)
    print_list(l2)
    print_list(l3)

    sol = Solution()
    merged_head = sol.mergeKLists(lists)

    print("\n--- Merged List ---")
    print_list(merged_head)
from typing import List

class Solution:
  def getMinimumTime(self, skill: List[int], mana: List[int]) -> int:
    n = len(skill)
    m = len(mana)

    if n == 0 or m == 0:
      return 0

    skill_prefix_sum = [0] * n
    skill_prefix_sum[0] = skill[0]
    for i in range(1, n):
      skill_prefix_sum[i] = skill_prefix_sum[i-1] + skill[i]

    padded_S = [0] + skill_prefix_sum

    start_time = 0
    
    for j in range(1, m):
      mana_prev = mana[j-1]
      mana_curr = mana[j]

      max_delay_factor = -float('inf')

      for i in range(n):
        delay_factor = skill_prefix_sum[i] * mana_prev - padded_S[i] * mana_curr
        if delay_factor > max_delay_factor:
          max_delay_factor = delay_factor
      
      start_time += max_delay_factor

    time_for_last_potion = skill_prefix_sum[n-1] * mana[m-1]
    
    return start_time + time_for_last_potion

# Example Usage:
solver = Solution()
print(f"Example 1: skill = [1,5,2,4], mana = [5,1,4,2]  -->  Time: {solver.getMinimumTime([1,5,2,4], [5,1,4,2])}")
print(f"Example 2: skill = [1,1,1], mana = [1,1,1]  -->  Time: {solver.getMinimumTime([1,1,1], [1,1,1])}")
print(f"Example 3: skill = [1,2,3,4], mana = [1,2]  -->  Time: {solver.getMinimumTime([1,2,3,4], [1,2])}")
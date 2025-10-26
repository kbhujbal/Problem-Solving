from typing import Counter


def task_scheduler(tasks, n):
    task_counts = Counter(tasks)

    max_freq = max(task_counts.values())

    max_freq_tasks = 0

    for count in task_counts.values():
        if count == max_freq:
            max_freq_tasks += 1

    intervals_needed = (max_freq - 1) * (n + 1) + max_freq_tasks

    return max(len(tasks), intervals_needed)

tasks = ["A","A","A", "B","B","B"]
n = 2
print(task_scheduler(tasks, n))

# 🧠 Core Idea
# The schedule's length is determined by one of two things:

# Total tasks: If we have many different tasks, we may never need to be idle. The answer is just len(tasks).

# The Bottleneck: The most frequent task forces idle time to satisfy its cooldown.

# The final answer is the max() of these two cases.

# ⚙️ The Formula
# The time required by the bottleneck (idle time) is:

# (max_freq - 1) * (n + 1) + max_freq_tasks

# 📊 Visual Breakdown
# Let's use tasks = ["A","A","A","B","B","B"], n = 2.

# max_freq = 3 (from 'A' and 'B')

# n = 2 (cooldown)

# max_freq_tasks = 2 (Tasks 'A' and 'B' both have the max frequency)

# Think in "frames": To space out the 'A's, the schedule must have this minimum structure. Each A is followed by n=2 slots. A -> ? -> ? -> A -> ? -> ? -> A

# (max_freq - 1) Frames: Notice the pattern is (A -> ? -> ?) which repeats for all but the last 'A'. This gives (3 - 1) = 2 full "frames."

# (n + 1) Slots per Frame: Each frame's length is (2 + 1) = 3 (one task + n cooldown slots).

# max_freq_tasks in Last Row: The last part of the schedule is the final occurrence of all tasks that have the max frequency. Here, that's A and B, so the "last row" has 2 tasks.

# Let's build a table from this idea:

#      Slot 1   Slot 2   Slot 3
#      +------+--------+--------+
# Row 1|   A  |    B   |  idle  |  <-- Frame 1: (max_freq - 1) = 2 full rows,
# Row 2|   A  |    B   |  idle  |    each of size (n + 1) = 3
#      +------+--------+--------+
# Last |   A  |    B   |        |  <-- The "last row" has max_freq_tasks = 2
#      +------+--------+
# Time from rows 1 & 2: (max_freq - 1) * (n + 1) = (3 - 1) * (2 + 1) = 2 * 3 = 6

# Time from last row: max_freq_tasks = 2

# Total Idle-Forced Time: 6 + 2 = 8

# 💡 Final Calculation
# Idle-Forced Time: 8

# Total Tasks Time: len(tasks) = 6

# The answer is the larger of the two: max(8, 6) = 8.
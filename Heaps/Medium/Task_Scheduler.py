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


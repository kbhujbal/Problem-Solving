def boats_to_save_people(people, limit):
    people.sort()

    left = 0
    right = len(people) - 1
    boats = 0

    while left <= right:
        boats += 1

        if (people[left] + people[right]) <= limit:
            left += 1

        right -= 1

    return boats



people = [3, 2, 2, 1]
limit = 3

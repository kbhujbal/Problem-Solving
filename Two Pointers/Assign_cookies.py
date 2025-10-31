def assign_cookies(children, cookies):
    children.sort()
    cookies.sort()

    child = 0
    cook = 0

    m = len(children)
    n = len(cookies)

    content = 0

    while child < m and cook < n:
        if children[child] <= cookies[cook]:
            content += 1
            child += 1
            cook += 1
        else:
            cook += 1

    return content



children = [1, 2, 3]
cookies = [1, 1]
print(f"{assign_cookies(children, cookies)} can be satisfied")
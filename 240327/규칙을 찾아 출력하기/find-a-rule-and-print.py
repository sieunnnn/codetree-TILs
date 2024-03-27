n = int(input())

for i in range(1, n + 1):
    if i == 1 or i == n:
        print('* ' * n)
    else:
        print('*' + ' ' * (2 * (i - 2)) + '*' + ' ' * (2 * (n - i)) + '*')
n = int(input())

size = 2 * n - 1

for i in range(1, n + 1):
    print(' ' * (n - i) + '* ' * (i - 1) + '*')

for i in range(n - 1, 0, -1):
    print(' ' * (n - i) + '* ' * (i - 1) + '*')
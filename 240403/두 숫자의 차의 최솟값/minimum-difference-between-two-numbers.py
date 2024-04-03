n = int(input())
numbers = list(map(int, input().split()))
min_diff = 99

for i in range(n):
    for j in range(i + 1, n):
        diff = abs(i - j)
        min_diff = min(min_diff, diff)

print(min_diff)
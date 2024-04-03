n = int(input())
numbers = list(map(int, input().split()))
list.sort(numbers)
min_diff = 99

for i in range(1, n):
    diff = numbers[i] - numbers[i - 1]
    min_diff = min(min_diff, diff)

print(min_diff)
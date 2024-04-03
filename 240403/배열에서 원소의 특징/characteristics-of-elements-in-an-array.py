numbers = list(map(int, input().split()))
last_index = len(numbers)

for i in range(last_index):
    if numbers[i] % 3 == 0:
        print(numbers[i - 1])
        break
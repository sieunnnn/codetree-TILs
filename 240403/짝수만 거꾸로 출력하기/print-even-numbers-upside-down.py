n = int(input())
numbers = list(map(int, input().split()))

list.reverse(numbers)

for number in numbers:
    if number % 2 == 0:
        print(number, end=" ")
n = int(input())

numbers = [i for i in range(9, 0, -1)]
index = 0

for i in range(n):
    for j in range(n):
        print(numbers[index], end="")
        
        if numbers[index] == 1:
            index = 0
        else:
            index += 1

    print()
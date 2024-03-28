n = int(input())
current = 0;

for i in range(1, n + 1):
    for j in range(1, n + 1):
        if i % 2 == 0:
            current += 2
            print(current, end=" ")
        elif i % 2 != 0:
            current += 1
            print(current, end=" ")
    print()
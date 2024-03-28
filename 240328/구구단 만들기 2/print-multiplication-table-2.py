a, b = map(int, input().split())
number = [2, 4, 6, 8]

for i in range(4):
    for j in range(b, a - 1, -1):
        if j != a:
            print(j, "*", number[i], "=", j * number[i], end=" / ")
        else:
            print(j, "*", number[i], "=", j * number[i], end="")
    print()
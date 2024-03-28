n = int(input())

last_index = n

for i in range(1, n + 1):
    for j in range(1, last_index + 1):
        if j != last_index:
            print(i, "*", j, "=", i * j, end=" / ")
        else:
            print(i, "*", j, "=", i * j, end="\n")
    
    last_index -= 1
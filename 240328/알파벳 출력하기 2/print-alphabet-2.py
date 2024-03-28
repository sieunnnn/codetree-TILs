from string import ascii_uppercase

n = int(input()) 
alpha_list = list(ascii_uppercase)
current_index = 0

for i in range(n):
    for j in range(i):
        print(" ", end=" ")
    for j in range(i, n):
        print(alpha_list[current_index], end=" ")
        current_index += 1
        if current_index > len(ascii_uppercase) - 1:
            current_index = 0
    print()
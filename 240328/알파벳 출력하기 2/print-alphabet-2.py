from string import ascii_uppercase

n = int(input()) 
alpha_list = list(ascii_uppercase)
current_index = 0

for j in range(n):
    for k in range(n):
        if k < j:
            print(" ", end=" ")
        else:
            print(alpha_list[current_index], end=" ")
            current_index += 1
            
            if current_index > len(alpha_list):
                current_index = 0
    print()
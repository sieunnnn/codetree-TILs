n = int(input())

for i in range(n):
    a, b = map(int, input().split())
    sum_even_numbers = 0

    for j in range(a, b + 1):
        if j % 2 == 0:
            sum_even_numbers += j
    
    print(sum_even_numbers)
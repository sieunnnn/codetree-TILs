n = int(input())

for i in range(n, 0, -1):
    left_stars = '*' * i
    right_stars = '*' * i
    middle_spaces = ' ' * (2 * (n - i))
    
    print(left_stars + middle_spaces + right_stars)
n = int(input())

if n == 1:
    print("*\n*")
    
else:
    print("* " * n)

    plus = 1
    minus = n - 1

    for _ in range(n):
        if plus <= n:
            print("* " * plus)
            plus += 1

        if minus > 0:
            print("* " * minus)
            minus -= 1
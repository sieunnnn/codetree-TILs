a, b, c = map(int, input().split())

if (a > b > c) :
    print(b)
elif (a > c > b) :
    print(c)
elif (b > a > c) :
    print(a)
elif (b > c > a) :
    print(c)
elif (c > b > a) :
    print(b)
elif (c > a > b) :
    print(a)
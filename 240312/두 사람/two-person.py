a, b = input().split()
c, d = input().split()

if (int(a) >= 19 and b == "M") :
    answer = 1
else :
    answer = 0

if (int(c) >= 19 and d == "M") :
    answer = 1
else :
    if (answer != 1) :
        answer = 0

print(answer)
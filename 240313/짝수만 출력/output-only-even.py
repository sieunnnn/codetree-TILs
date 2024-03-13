a, b = map(int, input().split())
answer = ""

if (a % 2 != 0) :
    a += 1

while (a <= b) :
    answer += str(a) + " "
    a += 2

print(answer)
a, b = map(int, input().split())
answer = ""

while (a >= b) :
    answer += str(a) + " " 
    a -= 2

print(answer)
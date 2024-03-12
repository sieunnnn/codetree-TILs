a, b = map(int, input().split())
answer = ""

for i in range(a, b - 1, -2) :
    answer += str(i) + " "

print(answer)
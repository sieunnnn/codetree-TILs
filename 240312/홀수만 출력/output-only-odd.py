a, b = map(int, input().split())
answer = ""

last = b + 1

for i in range(a, b + 1, 2) :
    answer += str(i) + " "

print(answer)
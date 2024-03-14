a, b = map(int, input().split())
answer = 1

for i in range(1, b + 1) :
    if i % a == 0 :
        answer *= i

print(answer)
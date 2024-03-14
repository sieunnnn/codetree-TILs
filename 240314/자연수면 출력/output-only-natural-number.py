a, b = map(int, input().split())
step = 1
answer = ""

while step <= b :
    if a <= 0 :
        print(0)
        break
    
    answer += str(a)
    step += 1

print(answer)
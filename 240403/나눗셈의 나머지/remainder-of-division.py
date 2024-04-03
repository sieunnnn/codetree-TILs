a, b = map(int, input().split())
count = [0] * (a + 1)
answer = 0

while a >= 1:
    remain = a % b
    count[remain] += 1

    a = a // b

for i in count:
    answer += (i * i)

print(answer)
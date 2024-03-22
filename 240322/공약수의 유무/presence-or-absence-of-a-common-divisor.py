a, b = map(int, input().split())
answer = False

for i in range(a, b):
    if (1920 % i == 0) and (2880 % i == 0):
        answer = True
        break

if answer == True:
    print(1)
else:
    print(0)
numbers = [0] * 5
for i in range(5):
    numbers[i] = int(input())

answer = True

for i in numbers:
    if i % 3 != 0:
        answer = False

if answer == True:
    print(1)
else:
    print(0)
n = int(input())
a = 1
count = 0

while n > 0:
    n = n // a
    a += 1
    count += 1

print(count)
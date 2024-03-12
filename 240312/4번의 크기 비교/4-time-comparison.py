a = int(input())
b, c, d, e = map(int, input().split())

if (a > b) :
    answer = "1\n"
else :
    answer = "0\n"

if (a > c) :
    answer += "1\n"
else :
    answer += "0\n"

if (a > d) :
    answer += "1\n"
else :
    answer += "0\n"

if (a > e) :
    answer += "1"
else :
    answer += "0"

print(answer)
a = int(input())
answer = ""

if (a % 3 == 0) :
    answer = "YES\n"
else :
    answer = "NO\n"

if (a % 5 == 0 or a == 5) :
    answer += "YES"
else :
    answer += "NO"

print(answer)
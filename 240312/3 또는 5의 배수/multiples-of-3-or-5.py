a = int(input())
answer = ""

if (a % 3 == 0) :
    answer = "YES"
else :
    answer = "NO"

if (a % 5 == 0) :
    answer += "\nYES"
else :
    answer = "\nNO"

print(answer)
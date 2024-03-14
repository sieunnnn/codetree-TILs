n = int(input())

for i in range(n) :
    temp = int(input())
    
    if ((temp % 2 != 0) and (temp % 3 == 0)) :
        print(temp)
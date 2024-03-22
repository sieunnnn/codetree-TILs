age_sum = 0
count = 0

while True:
    age = int(input())
    
    if 20 <= age <= 29:
        age_sum += age
        count += 1
    else:
        break

print("{:.2f}".format(age_sum / count))
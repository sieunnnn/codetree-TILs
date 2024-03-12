a, b = map(float, input().split())
c = float((a + b) / (a - b))

print(f"{round(c, 2):.2f}")
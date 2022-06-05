from collections import Counter

n, m, b = map(int, input().split())
land = []
min_val, max_val = 256, 0

for _ in range(n):
    land.extend(list(map(int, input().split())))

layer = n * m
heights = dict(Counter(land))
time_min = 256 * 2 * m * n
height_max = 0

for i in range(min(heights), max(heights) + 1):
    needs = layer * i
    if b + sum([key * val for key, val in heights.items()]) >= needs:
        time = 0
        for height, qty in heights.items():
            if i > height:
                time += qty
            elif i < height:
                time += 2 * qty
        if time < time_min:
            time_min = time
            height_max = i
        elif time == time_min:
            if i > height_max:
                height_max = i

print(time_min, height_max)
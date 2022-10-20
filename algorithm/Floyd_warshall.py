n, m = map(int, input().split())

graph = [[int(1e3)] * (n+1) for _ in range(n+1)]
for i in range(n+1):
    graph[i][i] = 0

for _ in range(m):
    f, t = map(int, input().split())
    graph[f][t] = 1
    graph[t][f] = 1
    
for k in range(n+1):
    for i in range(n+1):
        for j in range(n+1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

result = [sum(g) for g in graph]
print(result.index(min(result)))
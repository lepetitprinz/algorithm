
# Dijkstra Algorithm

def get_smallest_node():
	min_val = INF
	index = 0
	for i in range(1, n + 1):
	if distance[i] < min_val and not visited[i]:
		min_val = distance[i]
		index = i

	return index

def dijkstra(start):
	distance[start] = 0
	visited[start] = True

	for j in graph[start]:
		distance[j[0]] = j[1]

	for i in range(n - 1):
		now = get_smallest_node()
		visited[now] = True
		for j in graph[now]:
			cost = distance[now] + j[1]
			if cost < distance[j[0]]:
				distance[j[0]] = cost


INF = int(1e9)
n, m = map(int, input().split())    # n: node, m: edge
start = int(input())

graph = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)
distance = [INF] * (n + 1)

for _ in range(m):
	u, v, c = map(int, input().split())    # u : from, v: to, c: cost
	graph[u].append((b, v))


dijkstra(start)
for i in range(1, n + 1):
	if distance[i] == INF:
		print("INFINITY")
	else:
		print(distance[i])
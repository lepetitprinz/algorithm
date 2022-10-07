from heapq import heappush, heappop

def dijkstra(start):
	queue = []
	heappush(queue, (0, start))
	distance[start] = 0
	while queue:
		dist, now = heappop(queue)
		if distance[now] < dist:
			continue
		for i in graph[now]:
			cost = dist + i[1]
			if cost < distance[i[0]]:
				distance[i[0]] = cost
				heappush(queue, (cost, i[0]))

INF = int(1e9)

n, m = map(int, input().split())

start = int(input())
graph = [[] for _ in range(n + 1)]
distance = [INF] * (n + 1)

for _ in range(m):
	u, v, c = map(in, input().split())
	graph[u].append((v, c))


dijkstra(start)
for i in range(1, n + 1):
	if distance[i] == INF:
		print('INFINITY')
	else:
		print(distance[i])
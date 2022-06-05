import heapq


def solution(n, paths, gates, summits):
    M = int(1e7)
    points = {i: [] for i in range(1, n + 1)}
    intensity = {i: M for i in range(1, n + 1)}

    q = []
    for path in paths:
        p1, p2, time = path
        points[p1].append((time, p2))
        points[p2].append((time, p1))

    for gate in gates:
        heapq.heappush(q, (0, gate, 0))

    while q:
        (max_time, point, from_point) = heapq.heappop(q)
        if intensity[point] <= max_time:
            continue
        else:
            intensity[point] = max_time

        for path in points[point]:
            time, to = path
            if to in summits:
                max_time_tmp = max(max_time, time)
                intensity[to] = min(intensity[to], max_time_tmp)

            elif to in gates or to == from_point:
                continue

            else:
                max_time_tmp = max(max_time, time)
                if max_time_tmp < intensity[to]:
                    heapq.heappush(q, (max_time_tmp, to, point))

    check = {}
    for summit in summits:
        check[summit] = intensity[summit]

    intensity = sorted(check.items(), key=lambda x: x[1])

    return list(intensity[0])


n_ls = [6, 7, 7, 5]
paths_ls = [
    [[1, 2, 3], [2, 3, 5], [2, 4, 2], [2, 5, 4], [3, 4, 4], [4, 5, 3], [4, 6, 1], [5, 6, 1]],
    [[1, 4, 4], [1, 6, 1], [1, 7, 3], [2, 5, 2], [3, 7, 4], [5, 6, 6]],
    [[1, 2, 5], [1, 4, 1], [2, 3, 1], [2, 6, 7], [4, 5, 1], [5, 6, 1], [6, 7, 1]],
    [[1, 3, 10], [1, 4, 20], [2, 3, 4], [2, 4, 6], [3, 5, 20], [4, 5, 6]]
    ]
gates_ls = [
    [1, 3],
    [1],
    [3, 7],
    [1, 2]
]
summits_ls = [
    [6],
    [2, 3, 4],
    [1, 5],
    [5]
]

for n, path, gate, summit in zip(n_ls, paths_ls, gates_ls, summits_ls):
    result = solution(n, path, gate, summit)
    print(result)
def solution(alp, cop, problems):
    problems = add_total_power(problems)
    problems = sorted(problems, key=lambda x: x[-1])

    solved = []
    time = 0
    while problems:
        solvable = check_solve_prob(alp, cop, problems)
        if solvable == 'finished':
            break
        elif len(solvable) > 0:
            for problem in solvable:
                problems.remove(problem)
                solved.append(problem)
                alp, cop, time = solve_problem(alp, cop, time, problem)
        else:
            if len(solved) == 0:
                next_problem, _, _ = choose_next_problem(alp, cop, problems)
                alp, cop, time = increase_power(alp, cop, next_problem, time)
            else:
                choose, next_problem, solved_best = decide_solve_or_increase(alp, cop, solved, problems)
                if choose == 'solve':
                    alp, cop, time = solve_problem(alp, cop, time, solved_best)
                else:
                    alp, cop, time = increase_power(alp, cop, next_problem, time)

    # time = time - solved[-1][4]
    return time


def decide_solve_or_increase(alp, cop, solved, problems):
    next_problem, diff_alp, diff_cop = choose_next_problem(alp, cop, problems)
    solved_best = choose_best_solved(diff_alp, diff_cop, solved)
    choose = compare_solve_increase(diff_alp, diff_cop, solved_best)

    return choose, next_problem, solved_best


def choose_best_solved(diff_alp, diff_cop, solved):
    best = []
    for i, s in enumerate(solved):
        diff = diff_alp - s[0] + diff_cop - s[1]
        best.append([i, diff])
    best = sorted(best, key=lambda x: x[1])[0]

    return solved[best[0]]


def choose_next_problem(alp, cop, problems):
    ability_diff = []
    for i, prob in enumerate(problems):
        diff_alp = max(prob[0] - alp, 0)
        diff_cop = max(prob[1] - cop, 0)
        diff_sum = diff_alp + diff_cop
        ability_diff.append([diff_alp, diff_cop, diff_sum, i])
    next_problem = sorted(ability_diff, key=lambda x: x[2], reverse=False)[0]

    return problems[next_problem[3]], next_problem[0], next_problem[1]


def compare_solve_increase(diff_alp, diff_cop, solved_best):
    choose = ''
    alp_gap = max(diff_alp - solved_best[2], 0)
    cop_gap = max(diff_cop - solved_best[3], 0)

    if solved_best[4] <= (diff_alp + diff_cop - alp_gap - cop_gap):
        choose = 'solve'
    else:
        choose = 'increase'

    return choose


def increase_power(alp, cop, problem, time):
    alp_need = problem[0] - alp
    cop_need = problem[1] - cop
    time = time + alp_need + cop_need

    return problem[0], problem[1], time


def solve_problem(alp, cop, time, problem):
    alp += problem[2]
    cop += problem[3]
    time += problem[4]

    return alp, cop, time


def check_solve_prob(alp, cop, problems):
    solvable = []
    for problem in problems:
        if (alp >= problem[0]) and (cop >= problem[1]):
            solvable.append(problem)

    if len(solvable) == len(problems):
        solvable = 'finished'

    return solvable


def add_total_power(problems):
    for problem in problems:
        problem.append(problem[0] + problem[1])

    return problems


alp = 0
cop = 0
problems = [[0,0,2,1,2], [4,5,3,1,2], [4,11,4,0,2], [10,4,0,4,2]]

result = problem3(alp, cop, problems)
print(result)
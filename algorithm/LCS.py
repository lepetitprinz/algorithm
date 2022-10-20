# Longest Common Substring
if i == 0 and j == 0:    # set margin
	lsc[i][j] = 0
elif string_a[i] == string_b[j]:
	lsc[i][j] = lsc[i - 1][j - 1] + 1
else:
	lcs[i][j] = 0

# Longest Common Subsequence
if i == 0 or j == 0:
	lcs[i][j] = 0
elif string_a[i] == string_b[j]:
	lcs[i][j] = lcs[i - 1][j - 1] + 1
else:
	lsc[i][j] = max(lsc[i - 1][j], lsc[i][j - 1])
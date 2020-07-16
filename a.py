n = int(input())
cache=[-1 for i in range(21)]
def t(n):
	if n==1:
		return 1
	if n==2:
		return 2
	if cache[n]!=-1:
		return cache[n]
	else:
		return t(n-1)+t(n-2)

print(t(n))
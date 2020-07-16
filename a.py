n = int(input())
cachet=[-1 for i in range(21)]
def t(n):
	if n==1:
		return 1
	if n==2 :
		return 2
	if cachet[n]!=-1:
		return cachet[n]
	else:
		return t(n-1)+t(n-2)
	
def d(n):
	if n==1:
		return 1
	if n==2:
		return 2
	elif n%2==1:
		return t((n)//2)
	elif n%2==0:
		return t((n//2)-1) + t((n)//2)

print(t(n)-d(n))

n = int(input())

def fib(n):
	if n==1:
		return 1
	elif n==2:
		return 1
	else:
		return fib(n-1)+fib(n-2)
plus=0
for i in range(n):
	plus=plus+fib(i+1)
print(plus)
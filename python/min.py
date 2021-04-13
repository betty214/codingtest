a = int(input())
b = list(map(int, input().split(" ")))
min=b[0]
for i in range (a):
	if(min>b[i]):
		min=b[i]
print (min)
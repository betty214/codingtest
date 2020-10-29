n = int(input())
sum=0
for i in range(n+1):
	if (i%3==0):
		sum+=i
	elif(i%5==0):
		sum+=i
print (sum)
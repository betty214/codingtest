num1,num2=input().split(" ",1)
num1=int(num1)
num2=int(num2)

for i in range (num1,num2+1):
	sum=0
	for j in range(1,i):
		if (i%j==0):
			sum+=j
	if(sum==i):
		print(sum,end=" ")
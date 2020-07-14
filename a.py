import math
n = int(input())
n2=int(math.sqrt(n))
flag=0

for i in range(n2+1):
	if i==0 or i==1:
		continue
	elif (n//i)*i==n:
		flag=1
		break
	
		
if flag==0:
	print(True)
else:
	print(False)
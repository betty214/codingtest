x=list(map(int,input().split(" ")))
f=[0 for _ in range(len(x))]
count=0

for i in range(len(x)):
	if i==0:
		f[0]+=1
	else:
		count=0
		flag=True
		for j in range(i):
			if x[j]==x[i]:
				f[j]+=1
				flag=False
				break
		if flag==True:
			f[i]+=1
			
answer=f.index(max(f))
print(x[answer])
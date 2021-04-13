n1=list(map(int, input().split(" ")))
n2=list(map(int, input().split(" ")))
n3=list(map(int, input().split(" ")))
n4=[0 for i in range(n1[0]+n1[1])]
m=0
f=0
k=0
for i in range(n1[0]+n1[1]):
	if(m<n1[0] and f<n1[1]):
		if(n2[m]<n3[f]):
			n4[i]=n2[m]
			m+=1
			k+=1
		elif(n2[m]>=n3[f]):
			n4[i]=n3[f]
			f+=1
			k+=1
	elif(m>=n1[0]):
		while(f<n1[1]):
			n4[k]=n3[f]
			f+=1
			k+=1
	elif(f>=n1[1]):
		while(m<n1[0]):
			n4[k]=n2[m]
			m+=1
			k+=1
	
for i in range(len(n4)):
	print(n4[i],end=" ")
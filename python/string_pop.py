s = input()
j=0
for i in range(0,len(s)):
	if(i%2==0):
		print(s[j],end="")
		j+=1
	else:
		k=i//2+1
		print(s[len(s)-k],end="")
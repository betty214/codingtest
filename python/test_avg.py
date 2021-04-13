n = list(map(int, input().split(" ")))
sum=0
for i in range(len(n)):
	sum+=n[i]
sum=sum/len(n)
print("%.2f"% sum,end=" ")
if(sum>=90):
	print("A")
elif(sum>=80):
	print("B")
elif(sum>=70):
	print("C")
elif(sum>=60):
	print("D")
else:
	print("F")
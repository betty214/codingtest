user_input = int(input())
flag=1
half=int(user_input/2)
for i in range(2,half):
	if(user_input%i==0):
		flag=0
if(flag==1):
	print("True")
else:
	print("False")
H,U,D,F=list(map(int,input().split(" ")))
length=0
d=0
while True:
	d=d+1
	length=length+U-D
	U=U*(100-F)/100
	if length<0:
		print("Failure")
		break
	if H<length:
		print("Success %d" %(d-1))
		break
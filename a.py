a,b =map(int,input().split(" "))


def bi(a,b):
	if b==0:
		return 1
	elif a==b:
		return 1
	else:
		return bi(a-1,b-1)+bi(a-1,b)

print(bi(a,b))
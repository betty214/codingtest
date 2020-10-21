arr_len = int(input())
n=list(map(int, input().split()))
find=int(input())

flag=0
low=0
high=arr_len-1

while (low<=high):
	mid=(high+low)//2
	if (n[mid]>find):
		high=mid-1
	elif (n[mid]<find):
		low=mid+1
	elif(n[mid]==find):
		flag=1
		print (mid+1)
		break

if (flag==0):
	print("X")
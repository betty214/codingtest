num1,op,num2=input().split(" ",2)
if(op=='+'):
	num3=int(num1)+int(num2)
	print(num3)
elif(op=='-'):
	num3=int(num1)-int(num2)
	print(num3)
elif(op=='*'):
	num3=int(num1)*int(num2)
	print(num3)
elif(op=='/'):
	num3=int(num1)/int(num2)
	print('%.2f' % num3)
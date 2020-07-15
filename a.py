H,U,D,F=list(map(int,input().split(" ")))
pos=0
tired=U*(F/100)
flag=True
#한번이라도 이조건에 해당했을때
#한번이라도 이조건에 해당하지 않았을때 사용

while True:
    pos+=U
    if pos>=H:
        break #성공
    if U<0:
        flag=False #실패
        break
    U-=tired
    pos-=D
    date+=1

if flag==True:
    print("Success", date,)
else:
    print("Fail")
import java.util.Arrays;
class Solution {
    public int solution(String name) {
        char[]temp=name.toCharArray();
        int[]visited=new int[temp.length];
        int sum=0;int move=0;int now=0;
        int next=0;int c=0;int flag=0;
        while(c==0){
            visited[now]=1;
            int front = (int)(temp[next]-'A');
            int back = (int)('Z'-temp[next]+1);
            sum+=Math.min(front,back);
            if(flag==0){
                int t=0;
                for(int i=temp.length-1;i>0;i++){
                    if(temp[i]!='A'&&visited[i]==0){
                        t=i;
                        break;
                    }
                }if(t==0){
                        c=1;
                }
                if(next-now<now+temp.length-t){
                    move+=next-now;
                    now=next;
                    for(int i=now;i<temp.length;i++){
                        if(temp[i]!='A'&&visited[i]==0){
                        next=i;
                        break;
                    }
                    }
                }else{
                    flag=1;
                    move+=temp.length-next+now+1;
                now=next;
                for(int i=next;i>0;i--){
                    if(temp[i]!='A'&&visited[i]==0){
                        next=i;
                        break;
                    }else if(temp[i]!='A'&&visited[i]==1){
                        c=1;
                        break;
                    }
                }
                }
            }else{
                move+=temp.length-next+now+1;
                now=next;
                for(int i=next;i>0;i--){
                    if(temp[i]!='A'&&visited[i]==0){
                        next=i;
                        break;
                    }else if(temp[i]!='A'&&visited[i]==1){
                        c=1;
                        break;
                    }
                }
            }
        }
        System.out.println(move);
        int answer = sum+move;
        return answer;
    }
}
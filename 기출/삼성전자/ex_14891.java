package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class ex_14891 {
    static Deque<Integer>[] dq;
    static int [] sum ={1,2,4,8};
    static int [] turnArr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/14891.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dq = new ArrayDeque[5];

        for(int i=1;i<=4;i++){
            String now = br.readLine();
            dq[i]=new ArrayDeque<>();
            for(int j=0;j<8;j++){
                dq[i].addLast(Integer.parseInt(now.substring(j,j+1)));
            }
        }
        int K = Integer.parseInt(br.readLine());
        for(int i=0;i<K;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            boolean flag=false;
            turnArr=new int[5];
            turnArr[num]=dir;

            switch(num){
                case 1:
                    flag = cycle(1,2,2,dir);
                    if(flag) flag = cycle(2,3,3,-dir);
                    if(flag) cycle(3,4,4,dir);
                    break;
                case 2:
                    cycle(1,2,1,dir);
                    flag = cycle(2,3,3,dir);
                    if(flag) cycle(3,4,4,-dir);
                    break;
                case 3:
                    flag = cycle(2,3,2,dir);
                    if(flag) flag = cycle(1,2,1,-dir);
                    cycle(3,4,4,dir);
                    break;
                case 4:
                    flag = cycle(3,4,3,dir);
                    if(flag) flag = cycle(2,3,2,-dir);
                    if(flag) cycle(1,2,1, dir);
                    break;
            }
            for(int j=1;j<=4;j++){
                if(turnArr[j]!=0){
                    turn(j,turnArr[j]);
                }
            }
        }
        System.out.println(count());
    }static void turn(int index, int dir){
        if(dir==1){
            int now = dq[index].pollLast();
            dq[index].addFirst(now);
        }else{
            int now = dq[index].pollFirst();
            dq[index].addLast(now);
        }
    }static int getThird(int index){
        int first=dq[index].pollFirst();
        int second=dq[index].pollFirst();
        int third=dq[index].getFirst();
        dq[index].addFirst(second);
        dq[index].addFirst(first);
        return third;
    }static int getSix(int index){
        int first=dq[index].pollLast();
        int second=dq[index].getLast();
        dq[index].addLast(first);
        return second;
    }static boolean cycle(int x, int y, int next, int dir){
        int one = getThird(x);
        int two = getSix(y);
        if(one!=two) {
            turnArr[next]=-dir;
            return true;
        }
        return false;
    }static int count(){
        int answer=0;
        for(int i=1;i<=4;i++){
            if(dq[i].getFirst()==1) answer+=sum[i-1];
        }
        return answer;
    }
}
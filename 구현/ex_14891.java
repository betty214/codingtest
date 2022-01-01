package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ex_14891 {
    static ArrayList<Integer>[]gear;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gear=new ArrayList[4];
        for (int i = 0; i < 4; i++) {
            gear[i]=new ArrayList<>();
            String[] input = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                gear[i].add(Integer.parseInt(input[j]));
            }
        }
        int N=Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int turn = Integer.parseInt(st.nextToken());
            visited=new boolean[4];
            turn_gear(index-1,turn);
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(gear[i]);
        }
    }
    static void turn_gear(int index,int turn){
        if(turn==1){

            if(index>0 && gear[index-1].get(2)!=gear[index].get(6)){
                if(!visited[index-1]){
                    turn_gear(index-1,-1);
                }
            }
            if(index<3 &&gear[index+1].get(6)!=gear[index].get(2)){
                if(!visited[index+1]){
                    turn_gear(index+1,-1);
                }
            }            if(!visited[index]){
                int temp = gear[index].remove(7);
                gear[index].add(0,temp);
                visited[index]=true;
            }
        }else{

            if(index>0 && gear[index-1].get(2)!=gear[index].get(6)){
                if(!visited[index-1]){
                    turn_gear(index-1,1);
                }
            }if(index<3 && gear[index+1].get(6)!=gear[index].get(2)){
                if(!visited[index+1]){
                    turn_gear(index+1,1);
                }
            }            if(!visited[index]){
                int temp = gear[index].remove(0);
                gear[index].add(temp);
                visited[index]=true;
            }
        }
    }
}

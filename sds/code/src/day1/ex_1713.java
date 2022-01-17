package day1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ex_1713 {
    private static class People implements Comparable<People>{
        int vote;
        int number;
        int age;
        public People(int vote, int number,int age){
            this.vote=vote;
            this.number=number;
            this.age=age;
        }

        @Override
        public int compareTo(People o) {
            if(vote==o.vote){
                return o.age-age;
            }
            return vote-o.vote;
        }

    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day1/1713.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<People>photo=new ArrayList<>();
        for(int i=0;i<M;i++){
            int input = Integer.parseInt(st.nextToken());
            boolean flag=false;
            for(int j=0;j<photo.size();j++){
                if(photo.get(j)!=null){
                    if(photo.get(j).number==input){
                        flag=true;
                        photo.get(j).vote++;
                    }
                    photo.get(j).age++;
                }
            }
            if(!flag){
                if(photo.size()<N) {
                    photo.add(new People(1,input,0));
                }
                else{
                    Collections.sort(photo);
                    photo.set(0,new People(1,input,0));
                }
            }
        }
        Collections.sort(photo, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o1.number-o2.number;
            }
        });
        for(int i=0;i<photo.size();i++){
            System.out.print(photo.get(i).number+" ");
        }
        //comparator.comparingInt(Item::getB)
    }
}

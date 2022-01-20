package day3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ex_1202 {
    private static class Jam implements Comparable<Jam>{
        long M;
        long V;
        public Jam(long M,long V){
            this.M=M;
            this.V=V;
        }

        @Override
        public int compareTo(Jam o) {
            return (int) (M-o.M);
        }

        @Override
        public String toString() {
            return "Jam{" +
                    "M=" + M +
                    ", V=" + V +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day3/1202.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        ArrayList<Jam> Jewel = new ArrayList<>();
        PriorityQueue<Long>Bag = new PriorityQueue<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            long m=Long.parseLong(st.nextToken());
            long v=Long.parseLong(st.nextToken());
            Jewel.add(new Jam(m,v));
        }
        for(int i=0;i<K;i++){
            Bag.add(Long.parseLong(br.readLine()));
        }
        Collections.sort(Jewel);
        long answer=0;
        PriorityQueue<Jam>insert=new PriorityQueue<>(((o1, o2) -> (int) (o2.V-o1.V)));

        int index=0;
        for(int i=0;i<K;i++){
            long nowBag=Bag.poll();

            while(index<N){
                Jam nowJewel=Jewel.get(index);
                if(nowBag<nowJewel.M) break;
                insert.add(nowJewel);
                index++;
            }
            if(!insert.isEmpty()) {
                Jam ans=insert.poll();
                answer+=ans.V;
            }
            if(index>=N) break;
        }
        System.out.println(answer);
    }
}

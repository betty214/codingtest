package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class ex_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        for(int i=0;i<N;i++){
            int input=Integer.parseInt(br.readLine());
            if(input!=0){
                heap.add(input);
            }else if(heap.isEmpty()){
                System.out.println(0);
            }else{
                System.out.println(heap.poll());
            }
        }
    }
}

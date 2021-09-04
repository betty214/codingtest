package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ex_1655 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> left_q = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> right_q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if(left_q.size()==right_q.size()){
                left_q.add(input);
            }else{
                right_q.add(input);
            }
            if(!right_q.isEmpty() && left_q.peek()>right_q.peek()){
                left_q.add(right_q.poll());
                right_q.add(left_q.poll());
            }
            sb.append(left_q.peek() + "\n");
        }
        System.out.println(sb);
    }
}

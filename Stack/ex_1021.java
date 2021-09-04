package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class ex_1021 {
    static int N;
    static int answer;
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] out = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            out[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            dq.add(i + 1);
        }
        answer = 0;
        for (int i = 0; i < M; i++) {
            int find_index = find(out[i]);
            if (find_index <= (dq.size() / 2)+1) {
                left_cycle(out[i]);
            } else {
                right_cycle(out[i]);
            }
        }System.out.println(answer);
    }

    static int find(int f) {
        Iterator iteratorVals = dq.iterator();
        int index = 0;
        while (iteratorVals.hasNext()) {
            index++;
            if ((int) iteratorVals.next() == f) {
                break;
            }
        }
        return index;
    }

    static void left_cycle(int f) {
        if(f==dq.peekFirst()){
            dq.pollFirst();
        }else{
            while (f != dq.peekFirst()) {
                dq.addLast(dq.pollFirst());
                answer++;
            }if(f==dq.peekFirst()){
                dq.pollFirst();
            }
        }
    }
    static void right_cycle(int f) {
        if(f==dq.peekLast()){
            dq.pollLast();
            answer++;
        }else{
            while (f != dq.peekLast()) {
                dq.addFirst(dq.pollLast());
                answer++;
            }if(f==dq.peekLast()){
                dq.pollLast();
            }answer++;
        }
    }
}

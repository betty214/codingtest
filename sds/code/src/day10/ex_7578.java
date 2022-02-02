package day10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ex_7578 {
    static int N;
    static int [] A;
    static HashMap<Integer, Integer> B;
    static long [] Tree ;
    static int offset;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day10/7578.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int [N + 1];
        B = new HashMap<>();
        long answer = 0;
        int treeSize=getTreeSize();
        offset = (treeSize >> 1) - 1;
        Tree = new long [treeSize];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++) {
            B.put(Integer.parseInt(st.nextToken()), i);
        }

        int index;
        for(int i = 1 ; i <= N ; i++) {
            index = B.get(A[i]);
            answer += getSum(index+1, N);
            updateTree(index, 1);
        }
        System.out.println(answer);
    }
    private static void updateTree(int index, int value) { //자신의 자리에 1 추가
        index = index + offset;
        Tree[index] += value;
        for (index >>= 1; index != 0; index >>= 1) {
            Tree[index] = Tree[index * 2] + Tree[index * 2 + 1];
        }
    }

    private static long getSum(int left, int right) { //자신부터 끝까지중에 1이 몇개있는지 찾기
        long sum = 0;
        left += offset;
        right += offset;

        while (left <= right) {
            if (left % 2 == 1) {
                sum += Tree[left];
                left++;
            }
            if (right % 2 == 0) {
                sum += Tree[right];
                right--;
            }
            left >>= 1;
            right >>= 1;
        }
        return sum;
    }

    public static int getTreeSize() {
        int TreeSize = 1;
        while (TreeSize < N) {
            TreeSize = TreeSize * 2;
        }
        TreeSize = TreeSize * 2;
        return TreeSize;
    }
}



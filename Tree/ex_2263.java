package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ex_2263 {
	public static List<Integer> inorder,postorder,preorder;
	public static int index[];
	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		inorder=new ArrayList<>();
		index=new int [N+1];
		st=new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inorder.add(Integer.parseInt(st.nextToken()));
			index[inorder.get(i)]=i;
		}
		postorder=new ArrayList<>();
		st=new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			postorder.add(Integer.parseInt(st.nextToken()));
		}
		preorder=new ArrayList<>();
		tree(0,N-1,0,N-1);
		for(int i=0;i<N;i++) {
			System.out.print(preorder.get(i)+" ");
		}
	}
	public static void tree(int lfirst, int llast, int rfirst, int rlast) {
		if(lfirst>llast||rfirst>rlast) {
			return;
		}else {
			int root = postorder.get(rlast);
			preorder.add(root);
			int rindex=index[root];
			tree(lfirst,rindex-1,rfirst,rfirst+(rindex-1-lfirst));
			tree(rindex+1,llast,rfirst+(rindex-lfirst),rlast-1);
			return;
		}
	}
}

package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ex_1893 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			char A[] = br.readLine().toCharArray();
			List<Character> al = new ArrayList<Character>();
			for(int y=0;y<A.length;y++) {
				al.add(A[y]);
			}
			char[] W = br.readLine().toCharArray();
			String S = br.readLine();
			ArrayList <Integer> answer = new ArrayList<Integer>();
			for(int s=0;s<al.size();s++) {
				char[]shift=new char[W.length];
				for(int j=0;j<W.length;j++) {
					int a = al.indexOf(W[j]);
					if(a+s<A.length) {
						shift[j]=A[a+s];
					}else {
						shift[j]=A[a-A.length+s];
					}
				}String T = String.valueOf(shift);
				ArrayList<Integer> list = KMP(S, T);  //KMP 함수의 반환값 저장
				int size = list.size();            
				if(size==1) {
					answer.add(s);
				}
			}if(answer.size()==0) {
				System.out.println("no solution");
			}else if(answer.size()==1) {
				System.out.println("unique: "+answer.get(0));
			}else {
				System.out.print("ambiguous: ");
				for(int x=0;x<answer.size();x++) {
					System.out.print(answer.get(x)+" ");
				}System.out.println();
			}
		}
	}public static int[] getPi(String pattern) {  // 접두사와 접미사 매칭 Count
		int LenOfPattern = pattern.length();     // 찾을 Pattern's Length
		int []pi = new int[LenOfPattern];        // pi[] 할당
		int j = 0;                               // 패턴을 탐색할 인덱스
		
		for(int i=1; i<LenOfPattern; i++) {      // i = 1부터 
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) { // KMP알고리즘, 매칭되는 것 건너뛴다
				j = pi[j-1];                                         // j를 재할당 (건너 뜀)
			}if(pattern.charAt(i) == pattern.charAt(j)) {            // 접두사랑 접미사가 같다면
				pi[i] = ++j;                                         // 해당 인덱스 카운트  (길이)
			}
		}
		return pi;     // pi[] 반환
	}

	public static ArrayList<Integer> KMP(String str, String pattern) {  // 매칭되는 str을 ArrayList에 저장
		
		ArrayList<Integer> list = new ArrayList<>();      // 매칭된 str을 저장할 ArrayList
		int [] pi = getPi(pattern);                       // 찾을 패턴의 접두사와 접미사가 카운트된 배열 불러온다
		int LenOfStr = str.length();                      // 원본 str의 길이
		int LenOfPattern = pattern.length();              // 찾을 pattern의 길이
		int j = 0;                                        // pattern을 탐색시킬 인덱스
		
		for(int i=0; i<LenOfStr; i++) {                   // str의 0번째 (가장 처음부터)  탐색
			while(j > 0 && str.charAt(i)!= pattern.charAt(j)) {    // KMP 알고리즘의 핵심
				j = pi[j-1];                                       // j 재할당 (건너 뛴다)
			}if(str.charAt(i)== pattern.charAt(j)) {               // 문자가 같을 때
				if(j== LenOfPattern-1) {                           // 해당 인덱스가 패턴의 끝과 일치? 그럼 매칭 성공!
					list.add(i-LenOfPattern+1);                    // 찾은 패턴을 list에 순서대로 넣는다
					j = pi[j];                                     // j 초기화
				}else {                                   // 해당 인덱스가 패턴의 끝과 일치하지 않으면 더 찾아야 함!
					j++;                                  // 탐색 인덱스 증가!
				}
			}
		}
		return list;                                       // 매칭된 패턴이 저장된 list 반환
	}
}

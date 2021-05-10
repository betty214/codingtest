package eper;

import java.util.Scanner;

public class ex_new2 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [][]places=new String [5][5];
        char [][][]n = new char[5][5][5];
        int[] answer =new int[5];
        for(int i=0;i<5;i++) {
        	for(int j=0;j<5;j++) {
        		places[i][j]=sc.next();
        	}
        }
        for(int i=0;i<5;i++) {
        	for(int j=0;j<5;j++) {
        		n[i][j]=places[i][j].toCharArray();
        	}
        }
        int flag=1;
    	int[] dx = { 1, -1, 0, 0 };
    	int[] dy = { 0, 0, 1, -1 };
    	int[] tx = { 2, -2, 0, 0 };
    	int[] ty = { 0, 0, 2, -2 };
    	int[] px = { 1, -1, 1, -1 };
    	int[] py = { 1, -1, -1, 1 };
        for(int i=0;i<5;i++) {
        	for(int j=0;j<5;j++) {
        		for(int k=0;k<5;k++) {
        			if(n[i][j][k]=='P') {
        				for (int l = 0; l < 4; l++) {
        					int cx = j + dx[l];
        					int cy = k + dy[l];
        					int bx = j + tx[l];
        					int by = k + ty[l];
        					int ax = j + px[l];
        					int ay = k + py[l];
        					if (cx >= 0 && cy >= 0 && cx < 5 && cy < 5) {
        						if (n[i][cx][cy]=='P') {
        							flag=0;
        							break;
        						}
        					}
        					if (bx >= 0 && by >= 0 && bx < 5 && by < 5) {
        						if (n[i][bx][by]=='P'&&n[i][cx][cy]!='X') {
        							flag=0;
        							break;
        						}
        					}
        					if (ax >= 0 && ay >= 0 && ax < 5 && ay < 5&&cx >= 0 && cy >= 0 && cx < 5 && cy < 5) {
        						if (n[i][ax][ay]=='P'&&n[i][ax][k]!='X') {
        							flag=0;
        							break;
        						}if (n[i][ax][ay]=='P'&&n[i][j][ay]!='X') {
        							flag=0;
        							break;
        						}
        					}
        				}
        			}
        		}
        	}answer[i]=flag;
        	flag=1;
        }for(int i=0;i<5;i++) {
        	System.out.println(answer[i]);
        }
        
	}
}

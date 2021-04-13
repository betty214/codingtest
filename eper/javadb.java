package eper;

import java.util.ArrayList;

public class javadb {
	public static void main(String[] args) {
		   ArrayList<String> table_name  = new ArrayList<String>(); //전공명
           ArrayList<String> table_time  = new ArrayList<String>(); //월4금5등의 시간
           String[][] real_table = new String [5][8]; //실제 과목을 넣을 빈 시간표
           String[][] listen_name = new String [7][2]; //과목이 들어갔는지 표시하기 위한 플래그
           listen_name[0][0]="Advanced English";
           listen_name[0][1]="0";
           listen_name[1][0]="C프로그래밍및 실습";
           listen_name[1][1]="0";
           for(int i=0; i<table_time.size(); i++) {
        	   //시간이 1545이런식으로 되어있어서 변형한 것
         		  int day1=(Integer.parseInt(table_time.get(i).substring(0,1))-1); 
         		  int time1=(Integer.parseInt(table_time.get(i).substring(1,2))-1);
         		  int day2=(Integer.parseInt(table_time.get(i).substring(2,3))-1);
         		  int time2=(Integer.parseInt(table_time.get(i).substring(3,4))-1);
         		  int flag1=0,flag2=0;
         		  //분반 때문에 짠 코드인데 미완
         		  for (int k=0;k<7;k++) {
         			  if (table_name.get(i)==listen_name[k][0]&&listen_name[k][1]=="0") {
         				  System.out.println("일치합니다");
         				  listen_name[k][1]=table_time.get(i);
         			  }
         		  }
         		  if (real_table[day1][time1]==null&&real_table[day2][time2]==null) {
         			  real_table[day1][time1]=table_name.get(i);
         			  real_table[day2][time2]=table_name.get(i);
         		  }
   		}for(int i=0; i<5; i++) { //출력
   			for (int j=0;j<7;j++) {
   				System.out.print(real_table[i][j]+"|");
   			}System.out.println();
   		}for(int i=0; i<7; i++) {
   			for (int j=0;j<2;j++) {
   				System.out.print(listen_name[i][j]+"|");
   			}System.out.println();
   		}
	}
}

package com.lei.leibj;

import java.util.Scanner;

public class CardPlay {

	public static void main(String[] args) {

		int wincnt = 0;
		int losecnt = 0;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("ѡ��ׯ��1/�м�2��");	
			int input = sc.nextInt();
			int res=-1;
			if(input == 1) {
				Ruler ruler = new Ruler();
				res = ruler.play();
			}else if(input == 2) {
				Player player = new Player();
				res = player.play();
				
				
			}else {
				System.out.println("�����������������:");
			}
			
			if(res == 0) {
				System.out.println("����������...");
				losecnt++;
			}else if(res == 1) {
				System.out.println("������Ӯ��...");
				wincnt++;
			}else {
				System.out.println("ƽ�֣��������ǳ������^_^��");
			}
			
			System.out.println("�Ƿ�����µ�һ�֣�(Y/N)");
			char comfirm = sc.next().toUpperCase().charAt(0);
			if(comfirm == 'N') {
				System.out.println("��Ϸ����������ӭ����~");
				break;
			}
			
		}
		
		//����ս��
		System.out.println("����ս���С���");
		System.out.println("Ӯ��"+ wincnt + "��");
		System.out.println("�䣺"+ losecnt + "��");

	}

}

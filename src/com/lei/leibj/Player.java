package com.lei.leibj;

import java.util.Scanner;

public class Player {

	Scanner sc = new Scanner(System.in);
	
	//��Ϊ�м�	
	public int play() {
		
		int playerNum = 0;
		int rulerNum = 0;
		
		String player1, player2;
		String ruler1, ruler2;
		
		Card card = new Card();
		card.cutCard();
		card.cutCard();
		card.cutCard();
		JudgeNum judge = new JudgeNum();
		
		System.out.println("����Ϊ�мң�");
		System.out.println("����ʱ�䣺");
		
		player1 = card.deal();
		player2 = card.deal();		
		ruler1 = card.deal();
		ruler2 = card.deal();
		playerNum = judge.judge(player1) + judge.judge(player2);
		rulerNum = judge.judge(ruler1) + judge.judge(ruler2);	
		
		System.out.println("������ϣ�");
		System.out.println("�м�: " + player1 + " " + player2);
		System.out.println("�мҵ�����" + playerNum);
		System.out.println("ׯ��: " + ruler1 + " " + ruler2);
		System.out.println("ׯ�ҵ�����" + rulerNum);
		
		System.out.println("�м�Ҫ��ʱ�䡭��");
		while(true) {
			System.out.println("�м��Ƿ�Ҫ��(Y/N)?");
			
			char c = sc.next().toUpperCase().charAt(0);
			if(c == 'Y') {
				String player3 = card.deal();
				playerNum += judge.judge(player3);
				System.out.println("�мҵ��ƣ�"+player3 + "��������" + playerNum);
				if(playerNum > 21) {
					System.out.println("�мҵ�������21�㣬������...ׯ��Ӯ!");
					return 0;
				}
			}else if(c == 'N') {
				System.out.println("�мҲ���Ҫ�ƣ�ׯ��ʱ��...");
				break;
			}else {
				System.out.println("���벻��ȷ������������...");
			}
		}

		//ׯ��ʱ��
		while(true) {
			if(rulerNum < playerNum) {
				String ruler3 = card.deal();
				rulerNum += judge.judge(ruler3);
				System.out.println("ׯ�ҵ��ƣ�"+ruler3+"��������"+rulerNum);
			}else if(rulerNum > 21) {
				System.out.println("ׯ�ҵ�������21��������...�м�Ӯ��");
				return 1;//�м�Ӯ
			}else if(rulerNum > 15) {

				System.out.println("�ƶ�ʣ��" + card.card.length + "����.");
				if(rulerNum < playerNum) {
					return 1;//�м�Ӯ
				}
				return 0;//ׯ��Ӯ
			}else {
				String ruler3 = card.deal();
				rulerNum += judge.judge(ruler3);
				System.out.println("ׯ�ҵ��ƣ�"+ruler3+"��������"+rulerNum);
			}
		}

		
	}
}

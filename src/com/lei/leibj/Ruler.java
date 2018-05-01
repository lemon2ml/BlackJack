package com.lei.leibj;

import java.util.Scanner;

public class Ruler {

	//ѡ����ׯ��
	
	Scanner sc = new Scanner(System.in);
	public int play() {
		int playerNum = 0;
		int rulerNum = 0;
		
		String player1,player2;
		String ruler1, ruler2;
		
		Card card = new Card();
		card.cutCard();
		player1  = card.deal();
		player2  = card.deal();
		ruler1 = card.deal();
		ruler2 = card.deal();
		
		JudgeNum judge = new JudgeNum();
		playerNum = judge.judge(player1)+judge.judge(player2);
		rulerNum = judge.judge(ruler1)+judge.judge(ruler2);


		System.out.println("�м����飺" + player1 + ", " + player2 + "��������"+playerNum);
		System.out.println("ׯ�����飺" + ruler1 + ", " + ruler2 + "��������"+rulerNum);
		
		System.out.println("�мһغϡ���");	
		//�мһغ�
		while(true) {
			if(playerNum <= rulerNum || playerNum < 18) {
				playerNum = playerDealOnce(card, judge, playerNum);
			}else if(playerNum > 21) {
				System.out.println("�мҵ���:" + playerNum + "������21�㣬�����ˣ�");
				return 1;
			}else {
				break;
			}
		}
		//ׯ�һغ�
		System.out.println("ׯ�һغϡ���");
		
		while(true) {
			System.out.println("ׯ���Ƿ�Ҫ��(Y/N)?");
			char c = sc.next().toUpperCase().charAt(0);
			if(c == 'Y') {
				rulerNum = rulerDealOnce(card, judge, rulerNum);
				if(rulerNum>21) {
					System.out.println("ׯ�ҵ���:" + rulerNum + "������21�㣬�����ˣ�");
					return 0;
				}
				
			}else if (c == 'N') {
				if(rulerNum >= playerNum) {
					return 1;
				}
				return 0;
			}else {
				System.out.println("�����������������...");
			}
		}
	}
	
	public int rulerDealOnce(Card card, JudgeNum judge, int rulerNum) {
		String ruler3 = card.deal();
		rulerNum += judge.judge(ruler3);
		
		System.out.println("ׯ�ҵ��ƣ�" + ruler3 + "��������" + rulerNum);
		return rulerNum;
	}
	
	public int  playerDealOnce(Card card, JudgeNum judge, int playerNum) {
		String player3 = card.deal();
		playerNum += judge.judge(player3);
		
		System.out.println("�мҵ��ƣ�" + player3 + "��������" + playerNum);
		
		return playerNum;
	}
}

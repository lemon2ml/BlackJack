package com.lei.leibj;

import java.util.Scanner;

public class Player {

	Scanner sc = new Scanner(System.in);
	
	//作为闲家	
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
		
		System.out.println("您作为闲家！");
		System.out.println("发牌时间：");
		
		player1 = card.deal();
		player2 = card.deal();		
		ruler1 = card.deal();
		ruler2 = card.deal();
		playerNum = judge.judge(player1) + judge.judge(player2);
		rulerNum = judge.judge(ruler1) + judge.judge(ruler2);	
		
		System.out.println("发牌完毕！");
		System.out.println("闲家: " + player1 + " " + player2);
		System.out.println("闲家点数：" + playerNum);
		System.out.println("庄家: " + ruler1 + " " + ruler2);
		System.out.println("庄家点数：" + rulerNum);
		
		System.out.println("闲家要牌时间……");
		while(true) {
			System.out.println("闲家是否要牌(Y/N)?");
			
			char c = sc.next().toUpperCase().charAt(0);
			if(c == 'Y') {
				String player3 = card.deal();
				playerNum += judge.judge(player3);
				System.out.println("闲家得牌："+player3 + "，点数：" + playerNum);
				if(playerNum > 21) {
					System.out.println("闲家点数超过21点，爆牌了...庄家赢!");
					return 0;
				}
			}else if(c == 'N') {
				System.out.println("闲家不再要牌，庄家时间...");
				break;
			}else {
				System.out.println("输入不正确，请重新输入...");
			}
		}

		//庄家时间
		while(true) {
			if(rulerNum < playerNum) {
				String ruler3 = card.deal();
				rulerNum += judge.judge(ruler3);
				System.out.println("庄家得牌："+ruler3+"，点数："+rulerNum);
			}else if(rulerNum > 21) {
				System.out.println("庄家点数超过21，爆牌了...闲家赢！");
				return 1;//闲家赢
			}else if(rulerNum > 15) {

				System.out.println("牌堆剩余" + card.card.length + "张牌.");
				if(rulerNum < playerNum) {
					return 1;//闲家赢
				}
				return 0;//庄家赢
			}else {
				String ruler3 = card.deal();
				rulerNum += judge.judge(ruler3);
				System.out.println("庄家得牌："+ruler3+"，点数："+rulerNum);
			}
		}

		
	}
}

package com.lei.leibj;

import java.util.Scanner;

public class Ruler {

	//选择做庄家
	
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


		System.out.println("闲家牌组：" + player1 + ", " + player2 + "，点数："+playerNum);
		System.out.println("庄家牌组：" + ruler1 + ", " + ruler2 + "，点数："+rulerNum);
		
		System.out.println("闲家回合……");	
		//闲家回合
		while(true) {
			if(playerNum <= rulerNum || playerNum < 18) {
				playerNum = playerDealOnce(card, judge, playerNum);
			}else if(playerNum > 21) {
				System.out.println("闲家点数:" + playerNum + "，超过21点，爆牌了！");
				return 1;
			}else {
				break;
			}
		}
		//庄家回合
		System.out.println("庄家回合……");
		
		while(true) {
			System.out.println("庄家是否要牌(Y/N)?");
			char c = sc.next().toUpperCase().charAt(0);
			if(c == 'Y') {
				rulerNum = rulerDealOnce(card, judge, rulerNum);
				if(rulerNum>21) {
					System.out.println("庄家点数:" + rulerNum + "，超过21点，爆牌了！");
					return 0;
				}
				
			}else if (c == 'N') {
				if(rulerNum >= playerNum) {
					return 1;
				}
				return 0;
			}else {
				System.out.println("输入错误请重新输入...");
			}
		}
	}
	
	public int rulerDealOnce(Card card, JudgeNum judge, int rulerNum) {
		String ruler3 = card.deal();
		rulerNum += judge.judge(ruler3);
		
		System.out.println("庄家得牌：" + ruler3 + "，点数：" + rulerNum);
		return rulerNum;
	}
	
	public int  playerDealOnce(Card card, JudgeNum judge, int playerNum) {
		String player3 = card.deal();
		playerNum += judge.judge(player3);
		
		System.out.println("闲家得牌：" + player3 + "，点数：" + playerNum);
		
		return playerNum;
	}
}

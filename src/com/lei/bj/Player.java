package com.lei.bj;

import java.util.Random;
import java.util.Scanner;

public class Player {

	/*
	 * 选择做闲家 先得牌 您选择: 闲家 <br> 发牌时间: 闲家:红桃K 方片3 <br> 庄家:黑桃6 梅花4 闲家要牌时间: <br>
	 * 闲家是否要牌(Y/N)? <br> Y<br> 发牌:黑桃A 闲家是否要牌(Y/N)? <br> Y 发牌:梅花5 闲家是否要牌(Y/N)? <br> N
	 * 闲家不再要牌:<br> 闲家点数:19点<br> 庄家要牌时间: <br> 庄家要牌:梅花5 庄家要牌:黑桃4 <br> 庄家不再要牌:<br>
	 * 庄家点数19点 庄赢
	 *
	 *
	 *
	 */
	Scanner sc = new Scanner(System.in);

	public int play() {
		int playernum = 0;
		int rulernum = 0;
		String player1;
		String player2;

		String ruler1;
		String ruler2;

		JudgeNum judge = new JudgeNum();
		Card c = new Card();
		c.cutcards();
		player1 = c.deal();
		player2 = c.deal();

		System.out.println("发牌时间:");
		System.out.println("闲家:" + player1 + " " + player2);
		playernum = judge.judgeString(player1) + judge.judgeString(player2);

		ruler1 = c.deal();
		ruler2 = c.deal();
		System.out.println("庄家:" + ruler1 + " " + ruler2);
		rulernum = judge.judgeString(ruler1) + judge.judgeString(ruler2);
		System.out.println("闲家点数：" + playernum);

		System.out.println("庄家点数：" + rulernum);

		System.out.println("闲家要牌时间： ");

		// 循环要牌阶段
		while (true) {
			System.out.println("闲家是否要牌(Y/N)? ");

			char w = sc.next().toUpperCase().charAt(0);
			if (w == 'Y') {
				System.out.println("闲家继续要牌");
				String player3 = c.deal();
				System.out.println("闲家: " + player3);

				playernum = playernum + judge.judgeString(player3);
				System.out.println("闲家点数：" + playernum);
				if (playernum > 21) {
					System.out.println("闲家爆掉，庄家赢");
					return 0;
				}

			} else if (w == 'N') {
				System.out.println("闲家不再要牌，闲家点数:" + playernum);
				break;
			}

		}

		System.out.println("庄家要牌时间");

		while (true) {
			if (rulernum >= playernum) {
				System.out.println("庄家不再要牌，庄家赢");
				return 0;
			} else {
				System.out.println("庄家要牌时间：");
				String ruler3 = c.deal();
				System.out.println("庄家：" + ruler3);
				rulernum = rulernum + judge.judgeString(ruler3);
				if (rulernum > 21) {
					System.out.println("庄家点数" + rulernum);
					System.out.println("庄家爆掉，闲家赢");
					return 1;
				} else if (rulernum >= playernum) {

					System.out.println("庄家点数:" + rulernum + " 闲家点数:" + playernum);
					System.out.println("庄家赢");
					return 0;
				}

			}

		}

	}

}
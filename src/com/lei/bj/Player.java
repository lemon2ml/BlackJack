package com.lei.bj;

import java.util.Random;
import java.util.Scanner;

public class Player {

	/*
	 * ѡ�����м� �ȵ��� ��ѡ��: �м� <br> ����ʱ��: �м�:����K ��Ƭ3 <br> ׯ��:����6 ÷��4 �м�Ҫ��ʱ��: <br>
	 * �м��Ƿ�Ҫ��(Y/N)? <br> Y<br> ����:����A �м��Ƿ�Ҫ��(Y/N)? <br> Y ����:÷��5 �м��Ƿ�Ҫ��(Y/N)? <br> N
	 * �мҲ���Ҫ��:<br> �мҵ���:19��<br> ׯ��Ҫ��ʱ��: <br> ׯ��Ҫ��:÷��5 ׯ��Ҫ��:����4 <br> ׯ�Ҳ���Ҫ��:<br>
	 * ׯ�ҵ���19�� ׯӮ
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

		System.out.println("����ʱ��:");
		System.out.println("�м�:" + player1 + " " + player2);
		playernum = judge.judgeString(player1) + judge.judgeString(player2);

		ruler1 = c.deal();
		ruler2 = c.deal();
		System.out.println("ׯ��:" + ruler1 + " " + ruler2);
		rulernum = judge.judgeString(ruler1) + judge.judgeString(ruler2);
		System.out.println("�мҵ�����" + playernum);

		System.out.println("ׯ�ҵ�����" + rulernum);

		System.out.println("�м�Ҫ��ʱ�䣺 ");

		// ѭ��Ҫ�ƽ׶�
		while (true) {
			System.out.println("�м��Ƿ�Ҫ��(Y/N)? ");

			char w = sc.next().toUpperCase().charAt(0);
			if (w == 'Y') {
				System.out.println("�мҼ���Ҫ��");
				String player3 = c.deal();
				System.out.println("�м�: " + player3);

				playernum = playernum + judge.judgeString(player3);
				System.out.println("�мҵ�����" + playernum);
				if (playernum > 21) {
					System.out.println("�мұ�����ׯ��Ӯ");
					return 0;
				}

			} else if (w == 'N') {
				System.out.println("�мҲ���Ҫ�ƣ��мҵ���:" + playernum);
				break;
			}

		}

		System.out.println("ׯ��Ҫ��ʱ��");

		while (true) {
			if (rulernum >= playernum) {
				System.out.println("ׯ�Ҳ���Ҫ�ƣ�ׯ��Ӯ");
				return 0;
			} else {
				System.out.println("ׯ��Ҫ��ʱ�䣺");
				String ruler3 = c.deal();
				System.out.println("ׯ�ң�" + ruler3);
				rulernum = rulernum + judge.judgeString(ruler3);
				if (rulernum > 21) {
					System.out.println("ׯ�ҵ���" + rulernum);
					System.out.println("ׯ�ұ������м�Ӯ");
					return 1;
				} else if (rulernum >= playernum) {

					System.out.println("ׯ�ҵ���:" + rulernum + " �мҵ���:" + playernum);
					System.out.println("ׯ��Ӯ");
					return 0;
				}

			}

		}

	}

}
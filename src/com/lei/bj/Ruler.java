package com.lei.bj;

import java.util.Scanner;

public class Ruler {
 
    // ѡ����ׯ��
    /*
     * �м���Ҫ��
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
 
        System.out.println("�м�Ҫ��ʱ�䣺");
 
        while (true) {
            String player3;
            if (playernum <rulernum) {
                System.out.println("�м�Ҫ��");
                player3 = c.deal();
                System.out.println("�м�:" + player3);
                playernum = playernum + judge.judgeString(player3);
            } else if (playernum > 21) {
                System.out.println("�мҵ�����" + playernum);
 
                System.out.println("�мұ�����ׯ��Ӯ");
                return 0;
 
            } else if (playernum >= 15) {
                System.out.println("�мҲ���Ҫ��");
                System.out.println("�мҵ���" + playernum);
                break;
 
            }else {
                 
                System.out.println("�м�Ҫ��");
                String player4 = c.deal();
                System.out.println("�м�:" + player4);
                 
                playernum=playernum+judge.judgeString(player4);
                 
                 
                 if (playernum > 21) {
                        System.out.println("�мҵ�����" + playernum);
 
                        System.out.println("�мұ�����ׯ��Ӯ");
                        return 0;
            }
 
        }
    }
         
         
        // ׯ��Ҫ��ʱ��
        System.out.println("ׯ��Ҫ��ʱ�䣺");
 
        while (true) {
            System.out.println("ׯ���Ƿ�Ҫ��(Y/N)");
            char w = sc.next().toUpperCase().charAt(0);
            if (w == 'Y') {
                System.out.println("ׯ�Ҽ���Ҫ��");
                String ruler3 = c.deal();
                System.out.println("ׯ��: " + ruler3);
 
                rulernum = rulernum + judge.judgeString(ruler3);
                System.out.println("ׯ�ҵ�����" + rulernum);
                if (rulernum > 21) {
                    System.out.println("ׯ�ұ������м�Ӯ");
                    return 1;
                }
 
            } else if (w == 'N') {
                System.out.println("ׯ�Ҳ���Ҫ�ƣ�ׯ�ҵ���:" + rulernum);
                break;
            }
 
        }
 
        if (rulernum >= playernum) {
            System.out.println("ׯ��Ӯ");
            return 0;
        } else {
             
            System.out.println("�м�Ӯ");
             
            return 1;
        }
     
     
    }
    
}
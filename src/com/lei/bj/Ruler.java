package com.lei.bj;

import java.util.Scanner;

public class Ruler {
 
    // 选择做庄家
    /*
     * 闲家先要牌
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
 
        System.out.println("闲家要牌时间：");
 
        while (true) {
            String player3;
            if (playernum <rulernum) {
                System.out.println("闲家要牌");
                player3 = c.deal();
                System.out.println("闲家:" + player3);
                playernum = playernum + judge.judgeString(player3);
            } else if (playernum > 21) {
                System.out.println("闲家点数：" + playernum);
 
                System.out.println("闲家爆掉，庄家赢");
                return 0;
 
            } else if (playernum >= 15) {
                System.out.println("闲家不再要牌");
                System.out.println("闲家点数" + playernum);
                break;
 
            }else {
                 
                System.out.println("闲家要牌");
                String player4 = c.deal();
                System.out.println("闲家:" + player4);
                 
                playernum=playernum+judge.judgeString(player4);
                 
                 
                 if (playernum > 21) {
                        System.out.println("闲家点数：" + playernum);
 
                        System.out.println("闲家爆掉，庄家赢");
                        return 0;
            }
 
        }
    }
         
         
        // 庄家要牌时间
        System.out.println("庄家要牌时间：");
 
        while (true) {
            System.out.println("庄家是否要牌(Y/N)");
            char w = sc.next().toUpperCase().charAt(0);
            if (w == 'Y') {
                System.out.println("庄家继续要牌");
                String ruler3 = c.deal();
                System.out.println("庄家: " + ruler3);
 
                rulernum = rulernum + judge.judgeString(ruler3);
                System.out.println("庄家点数：" + rulernum);
                if (rulernum > 21) {
                    System.out.println("庄家爆掉，闲家赢");
                    return 1;
                }
 
            } else if (w == 'N') {
                System.out.println("庄家不再要牌，庄家点数:" + rulernum);
                break;
            }
 
        }
 
        if (rulernum >= playernum) {
            System.out.println("庄家赢");
            return 0;
        } else {
             
            System.out.println("闲家赢");
             
            return 1;
        }
     
     
    }
    
}
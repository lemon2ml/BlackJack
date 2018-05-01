package com.lei.bj;
import java.util.Scanner;

public class CardTest {
    
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        int win = 0;
        int lose = 0;
 
        while (true) {
            System.out.println("请问做庄家1/闲家2?");
            int num = sc.nextInt();
            if (num == 1) {
                System.out.println("你选择做庄家");
 
                Ruler r = new Ruler();
                int n=r.play();
                if(n==0) {
                     //庄家赢
                     win++;
                 }
                 else
                     lose++;
            } else if (num == 2) {
                System.out.println("你选择做闲家");
                Player p = new Player();
                 int n= p.play();
                 if(n==1) {
                     //闲家赢
                     win++;
                      
                 }
                 else
                     lose++;
            } else {
                System.out.println("输入错误，重新输入");
            }
 
            System.out.println("是否继续Y/N");
            if (sc.next().toUpperCase().charAt(0) == 'Y')
                continue;
            else {
                 
                System.out.println("游戏结束");
                System.out.println("赢："+win);
                System.out.println("输："+lose);
                break;
            }
 
        }
 
    }
 
}
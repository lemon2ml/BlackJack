package com.lei.bj;
import java.util.Scanner;

public class CardTest {
    
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        int win = 0;
        int lose = 0;
 
        while (true) {
            System.out.println("������ׯ��1/�м�2?");
            int num = sc.nextInt();
            if (num == 1) {
                System.out.println("��ѡ����ׯ��");
 
                Ruler r = new Ruler();
                int n=r.play();
                if(n==0) {
                     //ׯ��Ӯ
                     win++;
                 }
                 else
                     lose++;
            } else if (num == 2) {
                System.out.println("��ѡ�����м�");
                Player p = new Player();
                 int n= p.play();
                 if(n==1) {
                     //�м�Ӯ
                     win++;
                      
                 }
                 else
                     lose++;
            } else {
                System.out.println("���������������");
            }
 
            System.out.println("�Ƿ����Y/N");
            if (sc.next().toUpperCase().charAt(0) == 'Y')
                continue;
            else {
                 
                System.out.println("��Ϸ����");
                System.out.println("Ӯ��"+win);
                System.out.println("�䣺"+lose);
                break;
            }
 
        }
 
    }
 
}
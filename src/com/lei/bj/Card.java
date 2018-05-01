package com.lei.bj;

import java.util.Random;

public class Card {
 
    int index = 0; // ���������±�
    String[] card = { "����A", "����2", "����3", "����4", "����5", "����6", "����7", "����8",
             "����9", "����10", "����J", "����Q", "����K",
             "����A",
            "����2", "����3", "����4", "����5", "����6", "����7", "����8", "����9", "����10", "����J", "����Q", "����K",
            "÷��A", "÷��2", "÷��3",
            "÷��4", "÷��5", "÷��6", "÷��7", "÷��8", "÷��9", "÷��10", "÷��J", "÷��Q", "÷��K", "��ƬA", "��Ƭ2", "��Ƭ3", "��Ƭ4", "��Ƭ5",
            "��Ƭ6", "��Ƭ7", "��Ƭ8", "��Ƭ9", "��Ƭ10", "��ƬJ", "��ƬQ", "��ƬK", };
 
    public void show() {
        for (int i = 0; i < 52; i++) {
            System.out.println(card[i]);
        }
 
    }
 
    // ϴ�ƣ������Ƶ�˳��
    public void cutcards() {
        int index=0;
        Random rand = new Random();
        for (int i = 0; i < 52; i++) {
            int n = rand.nextInt(52);
            String temp;
            temp = card[n];
            card[n] = card[51 - n];
            card[51 - n] = temp;
        }
 
    }
 
    // ����,��˳���ƣ����±�0��ʼ
 
    public String deal() {
        String c = card[index];
        index++;
        return c;
    }
 
}
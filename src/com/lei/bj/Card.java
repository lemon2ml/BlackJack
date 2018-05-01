package com.lei.bj;

import java.util.Random;

public class Card {
 
    int index = 0; // 发牌索引下标
    String[] card = { "红桃A", "红桃2", "红桃3", "红桃4", "红桃5", "红桃6", "红桃7", "红桃8",
             "红桃9", "红桃10", "红桃J", "红桃Q", "红桃K",
             "黑桃A",
            "黑桃2", "黑桃3", "黑桃4", "黑桃5", "黑桃6", "黑桃7", "黑桃8", "黑桃9", "黑桃10", "黑桃J", "黑桃Q", "黑桃K",
            "梅花A", "梅花2", "梅花3",
            "梅花4", "梅花5", "梅花6", "梅花7", "梅花8", "梅花9", "梅花10", "梅花J", "梅花Q", "梅花K", "方片A", "方片2", "方片3", "方片4", "方片5",
            "方片6", "方片7", "方片8", "方片9", "方片10", "方片J", "方片Q", "方片K", };
 
    public void show() {
        for (int i = 0; i < 52; i++) {
            System.out.println(card[i]);
        }
 
    }
 
    // 洗牌，打乱牌的顺序
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
 
    // 发牌,按顺序发牌，从下标0开始
 
    public String deal() {
        String c = card[index];
        index++;
        return c;
    }
 
}
package com.lei.leibj;

import java.util.Arrays;
import java.util.Random;

public class Card {
	
	String[] card = { "红桃A", "红桃2", "红桃3", "红桃4", "红桃5", "红桃6", "红桃7", "红桃8", "红桃9", "红桃10", "红桃J", "红桃Q", "红桃K", "黑桃A",
			"黑桃2", "黑桃3", "黑桃4", "黑桃5", "黑桃6", "黑桃7", "黑桃8", "黑桃9", "黑桃10", "黑桃J", "黑桃Q", "黑桃K", "梅花A", "梅花2", "梅花3",
			"梅花4", "梅花5", "梅花6", "梅花7", "梅花8", "梅花9", "梅花10", "梅花J", "梅花Q", "梅花K", "方片A", "方片2", "方片3", "方片4", "方片5",
			"方片6", "方片7", "方片8", "方片9", "方片10", "方片J", "方片Q", "方片K", };

	int index = 0;

	// 洗牌
	public void cutCard() {
		Random r = new Random();
		for (int i = 0; i < 52; i++) {
			int n = r.nextInt(52);
			String temp = card[51 - n];
			card[51 - n] = card[n];
			card[n] = temp;
		}
	}

	// 发一张牌
	public String deal() {
		return card[index++];//此处简便处理，实际上应该每次发一张牌（牌堆顶，index=0），
							//然后将其从该数组中删除，数组后面元素向前移位。
	}


}

package com.lei.leibj;

import java.util.Arrays;
import java.util.Random;

public class Card {
	
	String[] card = { "����A", "����2", "����3", "����4", "����5", "����6", "����7", "����8", "����9", "����10", "����J", "����Q", "����K", "����A",
			"����2", "����3", "����4", "����5", "����6", "����7", "����8", "����9", "����10", "����J", "����Q", "����K", "÷��A", "÷��2", "÷��3",
			"÷��4", "÷��5", "÷��6", "÷��7", "÷��8", "÷��9", "÷��10", "÷��J", "÷��Q", "÷��K", "��ƬA", "��Ƭ2", "��Ƭ3", "��Ƭ4", "��Ƭ5",
			"��Ƭ6", "��Ƭ7", "��Ƭ8", "��Ƭ9", "��Ƭ10", "��ƬJ", "��ƬQ", "��ƬK", };

	int index = 0;

	// ϴ��
	public void cutCard() {
		Random r = new Random();
		for (int i = 0; i < 52; i++) {
			int n = r.nextInt(52);
			String temp = card[51 - n];
			card[51 - n] = card[n];
			card[n] = temp;
		}
	}

	// ��һ����
	public String deal() {
		return card[index++];//�˴���㴦����ʵ����Ӧ��ÿ�η�һ���ƣ��ƶѶ���index=0����
							//Ȼ����Ӹ�������ɾ�����������Ԫ����ǰ��λ��
	}


}

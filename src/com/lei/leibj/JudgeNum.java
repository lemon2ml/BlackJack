package com.lei.leibj;

public class JudgeNum {

	public int judge(String card) {
		char c = card.charAt(2);
		if(c == 'A') {
			return 1;
		}else if(c == 'J' || c== 'Q' || c=='K') {
			return 10;
		}else {
			String s = card.substring(2);
			return Integer.parseInt(s);
		}
	}
	
	
	public static void main(String[] args) {
		String card = "ºÚÌÒ10";
		int a = new JudgeNum().judge(card);
		System.out.println(a);
	}
}

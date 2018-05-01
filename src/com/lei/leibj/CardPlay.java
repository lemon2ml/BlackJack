package com.lei.leibj;

import java.util.Scanner;

public class CardPlay {

	public static void main(String[] args) {

		int wincnt = 0;
		int losecnt = 0;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("选择庄家1/闲家2？");	
			int input = sc.nextInt();
			int res=-1;
			if(input == 1) {
				Ruler ruler = new Ruler();
				res = ruler.play();
			}else if(input == 2) {
				Player player = new Player();
				res = player.play();
				
				
			}else {
				System.out.println("输入错误，请重新输入:");
			}
			
			if(res == 0) {
				System.out.println("本局您输了...");
				losecnt++;
			}else if(res == 1) {
				System.out.println("本局您赢了...");
				wincnt++;
			}else {
				System.out.println("平局！（可能是程序错误^_^）");
			}
			
			System.out.println("是否继续新的一局？(Y/N)");
			char comfirm = sc.next().toUpperCase().charAt(0);
			if(comfirm == 'N') {
				System.out.println("游戏结束……欢迎再玩~");
				break;
			}
			
		}
		
		//计算战绩
		System.out.println("计算战绩中……");
		System.out.println("赢："+ wincnt + "场");
		System.out.println("输："+ losecnt + "场");

	}

}

package competeTest.orther.jspwork4_1;

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		main.drawTriangle(6);
		main.gessNum(new Random().nextInt(100));
	}
	private void drawTriangle(int n){

		for (int i = 0; i < n; i++) {
			for (int j = i; j <n; j++) {
				System.out.print(" ");
			}
			for (int j = i; j >=0; j--) {
				System.out.print("*");
			}
			for (int j = i; j >=0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	private void gessNum(int num){
		System.out.println("猜数字开始！");
		Scanner sc = new Scanner(System.in);
		while (true){
			int ges = sc.nextInt();
			if(ges==num){
				System.out.println("猜对了!");return;
			}else if(ges>num){
				System.out.println("猜大了");
			}else if(ges<num){
				System.out.println("猜小了!");
			}else {
				System.out.println("出错了");
				return;
			}
		}
	}
	private void calendar(){

	}
	private int Arithmetic(){
		return 0;
	}
}

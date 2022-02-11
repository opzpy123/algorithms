package competeTest.orther.kaniu;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		//初始化牌库
		String[] colors = {"梅花", "方块", "红桃", "黑桃"};
		String[] brands = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		Card[] cards = new Card[52];
		int k = 0;
		for (int i = 0; i < colors.length; i++) {
			for (int j = 0; j < brands.length; j++) {
				if (k < 52) {
					cards[k++] = new Card(colors[i], brands[j]);
				}
			}
		}

		//初始化玩家
		List<Player> players = new ArrayList<>();
		Player player_1=new Player();
		Player player_2=new Player();
		Player player_3=new Player();
		Player player_4=new Player();
		players.add(player_1);
		players.add(player_2);
		players.add(player_3);
		players.add(player_4);

		//发牌
		sendCards(cards,players);

		//打印每个玩家手里的牌
		System.out.println("玩家1的牌:"+player_1);
		System.out.println("玩家2的牌:"+player_2);
		System.out.println("玩家3的牌:"+player_3);
		System.out.println("玩家4的牌:"+player_4);
	}

	private static void sendCards(Card[] cards,List<Player> players){
		//洗牌
		flushAllCards(cards);
		//发牌
		Player palyer_1 = players.get(0);
		Player palyer_2 = players.get(1);
		Player palyer_3 = players.get(2);
		Player palyer_4 = players.get(3);


		int num = cards.length/4;
		Card[] player_1_Cards = new Card[num];
		Card[] player_2_Cards = new Card[num];
		Card[] player_3_Cards = new Card[num];
		Card[] player_4_Cards = new Card[num];

		int index=0;
		for (int i = 0; i < num; i++) {
			player_1_Cards[index++]=cards[i];
		}
		palyer_1.setCards(player_1_Cards);
		index=0;
		for (int i = num; i < num*2; i++) {
			player_2_Cards[index++]=cards[i];
		}
		palyer_2.setCards(player_2_Cards);
		index=0;
		for (int i = num*2; i < num*3; i++) {
			player_3_Cards[index++]=cards[i];
		}
		palyer_3.setCards(player_3_Cards);
		index=0;
		for (int i = num*3; i < num*4; i++) {
			player_4_Cards[index++]=cards[i];
		}
		palyer_4.setCards(player_4_Cards);
	}

	private static void flushAllCards(Card[] cards) {
		Random random = new Random();
		for (int i = 0; i < cards.length; i++) {
			int num = random.nextInt(52);
			Card card = cards[num];
			cards[num]=cards[i];
			cards[i]=card;
		}
	}
}

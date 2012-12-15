package xphnx.ircat;

import java.util.Random;

public class PokerGame {
	
	static int playernum = 0;
	static String[] players = new String[8];
	static String[] card1 = new String[8];
	static String[] card2 = new String[8];
	static String[] deck = new String[52];
	static Random random = new Random();
	static int pot = 0;
	static int round = 0;
	public boolean started;
	public boolean playersmoved = false;
	public int playersleft = 0;
	public int winner = -1;
	
	public PokerGame(){
		System.out.println("Poker game being started");
		for(int i = 0; i < 52; i++){
			int j = i;
			int k = 0;
			while(j < 13){
				j = j - 13;
			}
			if(j < 10 && j > 1){
				deck[i] += Integer.toString(j);
			}else if(j == 10){
				deck[i] += "T";
			}else if(j == 11){
				deck[i] += "J";
			}else if(j == 12){
				deck[i] += "Q";
			}else if(j == 13){
				deck[i] += "K";
			}else if(j == 1){
				deck[i] += "A";			
			}
			if(k == 0){
				deck[i] += "C";
			}else if(k == 1){
				deck[i] += "S";
			}else if(k == 2){
				deck[i] += "D";
			}else if(k == 3){
				deck[i] += "H";
			}
		}
	}

	public void join(String sender) {
		players[playernum] = sender;
		dealCards(playernum);
		playernum++;
	}

	private void dealCards(int playernum2) {
		System.out.println("Dealing " + playernum2 + " his cards");
		boolean loopexit = false, loopexit2 = false;
		do{
			int card = random.nextInt(52);
			if(deck[card] != null){
				card1[playernum2] = deck[card];
				deck[card] = null;
				loopexit = true;
			}
		}while(loopexit == false);
		do{
			int card = random.nextInt(52);
			if(deck[card] != null){
				card1[playernum2] = deck[card];
				deck[card] = null;
				loopexit2 = true;
			}
		}while(loopexit2 == false);
	}

	public void stop() {
		System.out.println("Poker game stopping ;-;");
	}

	public void start() {
		waitForRound();
		if(playernum == 1){
			defaultWin();
		}else{
			dealFlop();
			waitForRound();
			if(playernum == 1){
				defaultWin();
			}else{
				dealRiver();
				waitForRound();
				if(playernum == 1){
					defaultWin();
				}else{
					dealRiver();
					waitForRound();
					if(playernum == 1){
						defaultWin();
					}else{
						showdown();
					}
				}
			}
		}
		
	}

	private void showdown() {
		// TODO Auto-generated method stub
		
	}

	private void defaultWin() {
		// TODO Auto-generated method stub
		
	}

	private void dealRiver() {
		// TODO Auto-generated method stub
		
	}

	private void dealFlop() {
		dealRiver();
		dealRiver();
		dealRiver();
	}

	private void waitForRound() {
		playersleft = playernum;
		while(playersleft > 0){
			//Most of this happens on the other side (BotMain)
			//We just wait for 
		}
		
	}

	public String getCards(String sender) {
		for(int i = 0; i < 8; i++){
			if(players[i] == sender){
				
			}
		}
		return null;
	}

}

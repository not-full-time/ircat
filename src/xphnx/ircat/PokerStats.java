package xphnx.ircat;

public class PokerStats {
	
	int playernum = -1;
	static String[] players = new String[65536];
	static int[] playermoney = new int[65536];

	public void addPlayer(String player){
		playernum++;
		players[playernum] = player;
		playermoney[playernum] = 1500;
	}
	
	public void addGame(PokerGame game){
		
	}

	public boolean newPlayer(String player) {
		for(int i = 0; i < 65536; i++){
			if(players[i] == player){
				return false;
			}
		}
		return true;
	}

}

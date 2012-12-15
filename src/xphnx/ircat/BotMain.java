package xphnx.ircat;

import java.util.Random;

import org.jibble.pircbot.PircBot;

public class BotMain extends PircBot {
	
	static PokerGame poker = null;
	static Random random = new Random();
	static PokerStats pokerstats = null;
	static PokerStats tourneystats = null;

	public BotMain() {
        this.setName("IRCat"); //Change this to the name of your bot
    }
	
	public void onMessage(String channel, String sender,
            String login, String hostname, String message) {
		if(message.equalsIgnoreCase("Hello")) {
			sendMessage(channel, "Meow!");
		}else if(message.equalsIgnoreCase(";-;")){
			sendMessage(channel, ":(");
		}else if(message.equalsIgnoreCase("Here is some food ircat")){
			sendMessage(channel, "Purrrr");
		}else if(message.equalsIgnoreCase(".poker")){
			if(poker == null){
				sendMessage(channel, "I'm starting a game of poker now!");
				if(pokerstats == null){
					pokerstats = new PokerStats();
				}
				newPokerGame();
				sendMessage(channel, "Type .joinpoker now to join.");
			}else{
				sendMessage(channel, "A game is already running!");
			}
		}else if(message.equalsIgnoreCase(".joinpoker")){
			if(poker != null){
				sendMessage(channel, sender + " joined the game!");
				if(pokerstats.newPlayer(sender)){
					pokerstats.addPlayer(sender);
				}
				poker.join(sender);
			}else if(poker.started){
				sendMessage(channel, "Game already started!");
			}else{
				sendMessage(channel, "No game is currently running!");
			}
		}else if(message.equalsIgnoreCase(".stoppoker")){
			if(poker != null){
				sendMessage(channel, "Game is stopping");
				stopPoker();
			}else{
				sendMessage(channel, "No game is currently running!");
			}
		}else if(message.equalsIgnoreCase(".startpoker")){
			if(poker == null){
				sendMessage(channel, "No game is currently running!");
			}else if(PokerGame.playernum <= 1){
				sendMessage(channel, "Not enough players!");
			}else{
				sendMessage(channel, "The game is starting now");
				poker.start();
			}
		}else if(message.startsWith(".pokerstats")){
			
		}else if(message.equalsIgnoreCase(".pokercards")){
			sendMessage(sender, poker.getCards(sender));
		}else if(message.equalsIgnoreCase(".hash")){
			sendMessage(channel, Integer.toString(hashCode()));
		}else if(message.equalsIgnoreCase(".coin")){
			sendMessage(channel, "The coin flies into the air...");
			int result = random.nextInt(2);
			if(result == 0){
				sendMessage(channel, "...it lands on heads.");
			}else if(result == 1){
				sendMessage(channel, "...it lands on tails.");
			}else{
				sendMessage(channel, "...it lands sideways.");
			}
		}else if(message.equalsIgnoreCase(".dice")){
			sendMessage(channel, "You roll the dice...");
			sendMessage(channel, "The first die rolls a " + (random.nextInt(6)+1));
			sendMessage(channel, "The second die rolls a " + (random.nextInt(6)+1));
		}else if(message.startsWith(".pokertourney")){
			if(message.equalsIgnoreCase(".pokertourney")){
				sendMessage(channel, "Usage: .pokertourney <playersnumber> <games>");
			}else{
				sendMessage(channel, "I'm starting a poker tournament now! Do .joinpokertourney to join.");
				newPokerTourney(message);
			}
		}
	}

	private void newPokerTourney(String message) {
		// TODO Auto-generated method stub
		
	}

	private void stopPoker() {
		poker.stop();
		poker = null;
	}

	private void newPokerGame() {
		poker = new PokerGame();
	}

}

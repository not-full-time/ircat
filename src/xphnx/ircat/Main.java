package xphnx.ircat;

import java.io.IOException;

import org.jibble.pircbot.IrcException;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		BotMain bot = new BotMain();
		try {
			bot.connect("irc.freenode.net");
		} catch (IOException | IrcException e) {
			System.out.println("Ircat had an accident!");
			e.printStackTrace();
		}
		bot.identify("ch1huahua");
		bot.joinChannel("#XphnX");
		System.out.println("Join successful");
	}

}

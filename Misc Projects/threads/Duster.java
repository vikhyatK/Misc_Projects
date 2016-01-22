package com.threads;

import java.util.Random;

public class Duster implements Runnable {
	private Board Board;

	public Duster(Board Board) {
		this.Board = Board;
	}

	public void run() {
		Random random = new Random();
		for (String message = Board.rub(); !message.equals("DONE"); message = Board.rub()) {
			System.out.println("Message Rubbed: " + message);
			try {
				Thread.sleep(random.nextInt(2000));
			} catch (InterruptedException e) {
			}
		}
	}
}

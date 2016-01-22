package com.threads;

import java.util.Random;

public class Marker implements Runnable {
	private Board board;

	public Marker(Board board) {
		this.board = board;
	}

	public void run() {
		String message[] = { "abc", "def",
				"ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		Random random = new Random();

		for (int i = 0; i < message.length; i++) {
			board.write(message[i]);
			try {
				Thread.sleep(random.nextInt(2000));
			} catch (InterruptedException e) {
			}
		}
		board.write("DONE");
	}
}

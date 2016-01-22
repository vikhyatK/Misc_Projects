package com.threads;

public class Board {

	private String message;

	private boolean empty = true;

	public synchronized String rub() {

		while (empty) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		empty = true;
		notifyAll();
		return message;
	}

	public synchronized void write(String message) {
		
		while (!empty) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		empty = false;
		System.out.println("Message Written : " + message);
		this.message = message;
		notifyAll();
	}
}

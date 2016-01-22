package com.threads;

public class TestMarkerDuster {
	public static void main(String[] args) {
		Board board = new Board();
		(new Thread(new Marker(board))).start();
		(new Thread(new Duster(board))).start();
	}
}

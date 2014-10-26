package android.labs.lab1.TwelveRocks;

import java.util.LinkedList;

public class GameLogic {
	
	private static int MAX_COUNT_ROCKS_TO_PICK = 3;
	private static int MIN_ROCKS_TO_PICK = 1;
	private static int ROCKS_LIMIT = 12;
	private static int WIN_LIMIT = 1;
	
	private static GameLogic me = null;
	private int currentRocksCount = 0;
	
	private Player winner = null;
	
	private GameLogic(){
		currentRocksCount = ROCKS_LIMIT;
	}
	
	public static GameLogic getInstance(){
		if (me == null){
			me = new GameLogic();
		}
		return me;
	}

	public int howManyRocksLeft() {
		return currentRocksCount;
	}

	public void pickSomeRocks(int rocksToPick) {
		this.currentRocksCount -= rocksToPick;
	}

	public static int getMinCountToPick() {
		return MIN_ROCKS_TO_PICK;
	}

	public static int getMaxCountToPick() {
		return MAX_COUNT_ROCKS_TO_PICK;
	}
	
	private boolean isPlayerWin(){
		//TODO
		return false;
	}
	
	private void play(LinkedList<Player> players){
		//TODO		
	}

	public Player getWinner() {
		return winner;
	}

}

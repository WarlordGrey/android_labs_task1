package android.labs.lab1.TwelveRocks.logic;

import android.labs.lab1.TwelveRocks.players.Player;


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
	
	private boolean isPlayerWon(){
		return (currentRocksCount <= WIN_LIMIT) ? true : false;
	}
	
	public void nextTurn(Player player){
		pickSomeRocks(player.getPickedRocks());
		if (isPlayerWon()){
			winner = player;
		}
	}
	
	public int getCurrentRocksCount(){
		return currentRocksCount;
	}

	public Player getWinner() {
		return winner;
	}
	
	public boolean isSomeoneWon(){
		return (winner != null);
	}
	
	public void newGame(){
		winner = null;
		currentRocksCount = ROCKS_LIMIT;
	}
	
	public void setWinner(Player winner){
		this.winner = winner;
	}
	
	public boolean isPlayerPickedLast(){
		return (currentRocksCount < WIN_LIMIT) ? true : false;
	}

}

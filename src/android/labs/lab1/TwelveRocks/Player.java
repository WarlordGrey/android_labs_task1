package android.labs.lab1.TwelveRocks;

public abstract class Player {
	
	private static String DEFAULT_NAME = "default player";
	
	private GameLogic logic = null;
	private String playerName = DEFAULT_NAME;
	private boolean humanPlayer = false;
	
	protected abstract int pickStrategy(int rocksCount);
	
	public void pickRocks(int rocksCount){
		
	}
	
	public void setName(String name){
		this.playerName = name;
	}
	
	public String getName(){
		return this.playerName;
	}
	
	public boolean isHumanPlayer() {
		return humanPlayer;
	}

	protected void setHumanPlayer(boolean humanPlayer) {
		this.humanPlayer = humanPlayer;
	}

	public GameLogic getLogic() {
		if (logic == null){
			logic = GameLogic.getInstance();
		}
		return logic;
	}

}

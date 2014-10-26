package android.labs.lab1.TwelveRocks;

public abstract class Player {
	
	private static String DEFAULT_NAME = "default player";

	private String playerName = DEFAULT_NAME;
	
	public void setName(String name){
		this.playerName = name;
	}
	
	public String getName(){
		return this.playerName;
	}
	
	public abstract int getPickedRocks();

}

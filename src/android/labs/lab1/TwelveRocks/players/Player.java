package android.labs.lab1.TwelveRocks.players;

import android.labs.lab1.TwelveRocks.R;
import android.labs.lab1.TwelveRocks.ui.MainUI;

public abstract class Player {
	
	private String playerName = MainUI.getInstance().getString(R.string.defaultPlayerName);
	
	public void setName(String name){
		this.playerName = name;
	}
	
	public String getName(){
		return this.playerName;
	}
	
	public abstract int getPickedRocks();
	
	public boolean isRockPicked(){
		return true;
	}
	
	public boolean isHumanPlayer(){
		return false;
	}

}
